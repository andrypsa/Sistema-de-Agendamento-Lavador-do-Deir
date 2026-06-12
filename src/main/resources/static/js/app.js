// Lógica de login, cadastro e modo admin
console.log("Sistema Lavador do Deir iniciado.");

const ADMIN_EMAIL = "admin@lavajato.com";
window.adminMode = false;

document.addEventListener("DOMContentLoaded", () => {

    const formLogin = document.getElementById("formLogin");
    const btnAcessoAdm = document.getElementById("btnAcessoAdm");
    const formCadastro = document.getElementById("formCadastro");

    if (btnAcessoAdm) {
        btnAcessoAdm.addEventListener("click", (e) => {
            e.preventDefault();

            window.adminMode = !window.adminMode;

            btnAcessoAdm.textContent = window.adminMode
                ? "Acesso ADM (ON)"
                : "Acesso ADM";

            btnAcessoAdm.style.background = window.adminMode
                ? "#1e3a5f"
                : "";

            btnAcessoAdm.style.color = window.adminMode
                ? "white"
                : "";
        });
    }

    if (formLogin) {
        formLogin.addEventListener("submit", async (e) => {
            e.preventDefault();

            const email = document.getElementById("email").value;
            const senha = document.getElementById("senha").value;

            try {
                const resposta = await fetch("http://localhost:8080/clientes/login", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        email: email,
                        senha: senha
                    })
                });

                const usuario = await resposta.json();

                if (!usuario || !usuario.id) {
                    alert("E-mail ou senha inválidos.");
                    return;
                }

                let role = "client";

                if (window.adminMode && email.toLowerCase() === ADMIN_EMAIL) {
                    role = "admin";
                }

                sessionStorage.setItem("user", JSON.stringify(usuario));
                sessionStorage.setItem("role", role);

                if (role === "admin") {
                    window.location.href = "admin.html";
                } else {
                    window.location.href = "dashboard.html";
                }

            } catch (erro) {
                console.log(erro);
                alert("Erro ao conectar com o servidor.");
            }
        });
    }

    if (formCadastro) {
        formCadastro.addEventListener("submit", async function (event) {
            event.preventDefault();

            const cliente = {
                nome: document.getElementById("nome").value,
                telefone: document.getElementById("telefone").value,
                email: document.getElementById("email").value,
                senha: document.getElementById("senha").value
            };

            try {
                const resposta = await fetch("http://localhost:8080/clientes/cadastrar", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(cliente)
                });

                const mensagem = await resposta.text();

                if (mensagem.includes("sucesso")) {
                    alert("Parabéns! Sua conta foi criada com sucesso. Faça seu login agora mesmo.");
                    window.location.href = "login.html";
                } else {
                    alert(mensagem);
                }

            } catch (erro) {
                console.log(erro);
                alert("Erro ao cadastrar cliente.");
            }
        });
    }

});