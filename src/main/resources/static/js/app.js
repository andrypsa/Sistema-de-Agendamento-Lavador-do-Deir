// Lógica de login, cadastro e modo admin
console.log("Sistema Lavador do Deir iniciado.");

const ADMIN_EMAIL = "admin@lavajato.com";
window.adminMode = false;

document.addEventListener("DOMContentLoaded", () => {

    const formLogin = document.getElementById("formLogin");
    const btnAcessoAdm = document.getElementById("btnAcessoAdm");
    const formCadastro = document.getElementById("formCadastro");

    // Ativa ou desativa o modo de acesso administrativo na tela de login
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

    // Realiza o login do cliente ou do administrador
    if (formLogin) {
        formLogin.addEventListener("submit", async (e) => {
            e.preventDefault();

            const email = document.getElementById("email").value;
            const senha = document.getElementById("senha").value;

            // Impede que um cliente comum tente acessar o sistema como administrador
            if (window.adminMode && email.toLowerCase() !== ADMIN_EMAIL) {
                alert("Acesso negado. Este usuário não possui permissão de administrador. Desative o Acesso ADM para entrar como cliente.");
                return;
            }

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

                // Define o tipo de usuário logado
                if (window.adminMode && email.toLowerCase() === ADMIN_EMAIL) {
                    role = "admin";
                }

                // Armazena os dados do usuário na sessão do navegador
                sessionStorage.setItem("user", JSON.stringify(usuario));
                sessionStorage.setItem("role", role);

                // Redireciona o usuário para a tela correspondente ao seu perfil
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

    // Realiza o cadastro de um novo cliente
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