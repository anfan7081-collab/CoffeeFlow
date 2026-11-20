# CoffeeFlow

## Título do projeto
**CoffeeFlow — Sistema desktop de gestão de cafeteria**

## Status do projeto
Projeto acadêmico em desenvolvimento, desenvolvido no Projeto Integrador do curso Técnico em Desenvolvimento de Sistemas.

## Tecnologias utilizadas
- Java 17
- Java Swing (interface desktop)
- JDBC
- MySQL
- MySQL Connector/J
- Apache Maven
- Apache NetBeans IDE
- Git e GitHub (versionamento do projeto)

## Time de desenvolvedores
Projeto acadêmico desenvolvido por: **[PREENCHER COM O NOME DO(A) ALUNO(A) OU DA EQUIPE]**.

## Objetivo do software
O CoffeeFlow tem como objetivo apoiar a gestão de uma cafeteria, centralizando o cadastro e a consulta de produtos, funcionários, insumos, receitas e pedidos, além de apresentar indicadores e relatórios operacionais.

## Funcionalidades do sistema
- Visualização do painel inicial com indicadores e pedidos recentes.
- Cadastro, consulta, edição e exclusão de produtos.
- Cadastro, consulta, edição e exclusão de funcionários.
- Cadastro, consulta, edição e exclusão de insumos e controle de estoque.
- Cadastro e consulta de receitas e seus vínculos com produtos e insumos.
- Registro e consulta de pedidos.
- Relatórios com indicadores de vendas e pedidos.
- Persistência e consulta dos dados por meio de conexão Java/JDBC com MySQL.

## Banco de dados
O script de criação e carga inicial está em `database/CoffeeFlow.sql`.

Antes de executar o sistema:
1. Inicie o servidor MySQL.
2. Execute o script `database/CoffeeFlow.sql` no MySQL Workbench.
3. Abra a pasta que contém `pom.xml` no Apache NetBeans.
4. Aguarde o Maven resolver as dependências e execute **Clean and Build**.
5. Execute a classe `br.com.coffeeflow.app.Main`.

Configuração padrão da conexão:
- URL: `jdbc:mysql://localhost:3306/CoffeeFlow?serverTimezone=UTC`
- Usuário: `root`
- Senha: vazia

Se necessário, configure as variáveis de ambiente `COFFEEFLOW_DB_URL`, `COFFEEFLOW_DB_USER` e `COFFEEFLOW_DB_PASSWORD`. Não publique senhas ou credenciais no repositório.

## Estrutura principal
- `src/main/java/br/com/coffeeflow/app/` — interface e inicialização do sistema.
- `src/main/java/br/com/coffeeflow/config/` — configuração de conexão JDBC.
- `src/main/java/br/com/coffeeflow/dao/` — acesso a dados.
- `src/main/java/br/com/coffeeflow/model/` — classes de domínio.
- `database/` — script SQL.
- `documentacao/` — documento de requisitos e diagrama UML.

## Versionamento
Este projeto é versionado com Git e hospedado em um repositório remoto no GitHub. O histórico de commits e as evidências de publicação devem ser registrados pelo(a) estudante durante a execução da Etapa 5.
