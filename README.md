# Projeto de Extensão I - Análise e Desenvolvimento de Sistemas

## Sistema de Agendamento de Serviços - Lavador do Deir

Este projeto foi desenvolvido como parte do Projeto de Extensão do curso de Análise e Desenvolvimento de Sistemas.
O sistema tem como objetivo auxiliar o Lavador do Deir, um pequeno estabelecimento de lavagem automotiva localizado no estado de Goiás, na organização dos agendamentos, controle dos atendimentos e comunicação com os clientes.

## Sobre o projeto

O Lavador do Deir é um estabelecimento de pequeno porte, administrado pelo próprio proprietário. Além do serviço de lavagem, o proprietário também trabalha com aplicativo de transporte e, em alguns momentos, precisa se ausentar, deixando o lavador fechado.
Com isso, alguns clientes podem se deslocar até o estabelecimento e não encontrar atendimento disponível, causando perda de tempo, gastos desnecessários com combustível e desencontros entre cliente e prestador de serviço.
Diante dessa necessidade, foi proposta a criação de um sistema web para gerenciamento de agendamentos, permitindo que os clientes solicitem horários previamente e que o proprietário organize melhor sua rotina de atendimentos.

## Objetivos

* Organizar os agendamentos de serviços;
* Evitar desencontros entre clientes e o estabelecimento;
* Reduzir deslocamentos desnecessários;
* Melhorar a comunicação com os clientes;
* Auxiliar na rotina administrativa do proprietário;
* Contribuir para práticas mais organizadas e sustentáveis.

## Objetivos de Desenvolvimento Sustentável (ODS)

Este projeto está relacionado aos seguintes Objetivos de Desenvolvimento Sustentável da ONU:

* ODS 11 – Cidades e Comunidades Sustentáveis: contribui para uma melhor organização dos serviços locais e facilita o acesso dos clientes ao atendimento;
* ODS 12 – Consumo e Produção Responsáveis: apoia o uso mais organizado dos recursos do estabelecimento, evitando conflitos de horários, retrabalho e melhorando o planejamento dos atendimentos;
* ODS 13 – Ação Contra a Mudança Global do Clima: contribui indiretamente para a redução de deslocamentos desnecessários dos clientes, já que o sistema permite consultar e solicitar horários de forma online.

## Funcionalidades

### Cliente

* Cadastro de cliente;
* Login de cliente;
* Solicitação de agendamento de lavagem;
* Escolha do tipo de veículo, data e horário;
* Bloqueio de agendamento aos domingos;
* Bloqueio de horários já solicitados ou aprovados;
* Visualização dos agendamentos em andamento;
* Consulta ao histórico de lavadas;
* Consulta ao progresso no programa de fidelidade;
* Visualização de cupons disponíveis.

### Administrador

* Login administrativo;
* Visualização de agendamentos por status;
* Aprovação de agendamentos;
* Recusa de agendamentos com justificativa;
* Marcação de atendimentos como concluídos;
* Controle dos cupons gerados;
* Marcação de cupons como utilizados.

## Programa de fidelidade

O sistema possui um controle simples de fidelidade.
A cada 10 lavadas concluídas, o cliente recebe automaticamente um cupom de 25% de desconto. Após a geração do cupom, a contagem de lavadas é reiniciada para um novo ciclo.
Os cupons possuem data de geração, data de validade e controle de utilização.

## Tecnologias utilizadas

* Java 17;
* Spring Boot;
* Maven;
* HTML5;
* CSS3;
* JavaScript;
* Jackson Databind;
* JSON para persistência de dados;
* Visual Studio Code;
* Git e GitHub.
* GitHub Copilot
* ChatGPT

## Persistência de dados

Inicialmente, a ideia era utilizar um banco de dados relacional. Porém, durante o desenvolvimento, foi adotada a persistência em arquivos JSON, mantendo o sistema mais simples e adequado ao objetivo acadêmico do projeto.
Essa escolha permitiu armazenar as informações de clientes, agendamentos, cupons e notificações de forma organizada, sem a necessidade de configuração de um banco de dados externo.

## Como executar o projeto

### Pré-requisitos

Antes de executar o sistema, é necessário ter instalado:

* Java 17;
* Maven;
* Git, opcional para clonar o repositório.

### Passos para execução

Clone o repositório:

```bash
git clone https://github.com/andrypsa/Sistema-de-Agendamento-Lavador-do-Deir.git
```

Acesse a pasta do projeto:

```bash
cd Sistema-de-Agendamento-Lavador-do-Deir
```

Execute o projeto com Maven:

```bash
mvn spring-boot:run
```

Após iniciar o backend, acesse a tela de login pelo navegador:

```text
http://localhost:8080/pages/login.html
```

Também é possível abrir as páginas pelo Live Server, mantendo o backend em execução.

## Acesso administrativo

Para acessar o painel administrativo, utilize o botão `Acesso ADM` na tela de login e informe:

```text
E-mail: admin@lavajato.com
Senha: admin123
```

## Estrutura do projeto

```text
src/
 └── main/
     ├── java/
     │   └── com/lavajato/backend/
     │       ├── controller/
     │       ├── model/
     │       ├── repository/
     │       └── service/
     └── resources/
         └── static/
             ├── css/
             ├── img/
             ├── js/
             └── pages/

dados/
 ├── clientes.json
 ├── agendamentos.json
 ├── cupons.json
 └── notificacoes.json
```

## Próximos passos

Como melhorias futuras, o sistema poderá receber novas funcionalidades e adaptações, como:

* Desenvolvimento de uma versão mobile ou aplicativo para celular;
* Integração com banco de dados relacional, como MySQL ou PostgreSQL;
* Implantação do sistema em ambiente online;
* Envio de notificações automáticas para clientes sobre aprovação, recusa ou conclusão de agendamentos;
* Integração com WhatsApp para confirmação de horários;
* Melhorias no painel administrativo;
* Cadastro de serviços com valores estimados;
* Geração de relatórios simples sobre atendimentos realizados;
* Melhorias na segurança do login e controle de acesso.

Essas melhorias podem tornar o sistema mais completo e facilitar ainda mais o uso tanto pelo proprietário quanto pelos clientes.

## Status do projeto

Projeto finalizado para entrega acadêmica, com possibilidade de melhorias futuras.

## Sobre o desenvolvimento

Durante o desenvolvimento, foram aplicados conhecimentos de lógica de programação, orientação a objetos, estruturação de dados, desenvolvimento web, organização de funcionalidades e persistência de informações.
O projeto foi desenvolvido com foco em uma necessidade real da comunidade local, buscando criar uma solução simples e prática para auxiliar um pequeno negócio na organização dos atendimentos e no relacionamento com os clientes.

## Direitos de uso

Este projeto foi desenvolvido para fins acadêmicos, como parte de um Projeto de Extensão do curso de Análise e Desenvolvimento de Sistemas.
O código, a estrutura do sistema e a proposta pertencem à autora do projeto. Não é autorizada a cópia, distribuição, reprodução ou uso comercial deste projeto sem autorização prévia.
O repositório está público apenas para fins de avaliação acadêmica e composição de portfólio.

© 2026 - Projeto desenvolvido por Andrielly Patrícia S. Araújo para fins acadêmicos e de portfólio.
