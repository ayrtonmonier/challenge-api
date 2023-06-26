# Desafio de Consulta de Pessoas

Este é um projeto de consulta de pessoas desenvolvido como parte de um desafio técnico. A aplicação permite buscar pessoas com base em critérios como tipo e região.

https://github.com/juntossomosmais/code-challenge

## Requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

- JDK 11 ou superior
- Spring Boot 2.7.13
- Maven 3.9.2

Nota: As versões utilizadas para este teste foram escolhidas para se aproximar ao ambiente do cliente.

## Configuração do Banco de Dados

O projeto utiliza um banco de dados relacional para armazenar as informações das pessoas. Certifique-se de ter um banco de dados configurado e atualize as informações de conexão no arquivo.  `application.properties`. Por padrão o banco de dados em memória H2 está sendo utilizado para testes e possuem as devidas configurações jpa setadas neste arquivo de propriedades.

## Executando a Aplicação

1. Clone o repositório para o seu ambiente de desenvolvimento.
2. Navegue até o diretório do projeto.
3. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.
4. Acesse a URL `http://localhost:8080` no seu navegador para utilizar a aplicação.

## API de Consulta de Pessoas

A aplicação expõe uma API para consultar pessoas com base em critérios. A seguir estão os endpoints disponíveis:

### Consultar Pessoas Elegíveis

GET /persons?type={tipo}&region={região}&page={página}&size={tamanho}

- `tipo`: Tipo de pessoa (case insensitive)
- `região`: Região da pessoa (case insensitive)
- `página`: Número da página (opcional, padrão: 1)
- `tamanho`: Tamanho da página (opcional, padrão: 10)

Exemplo de consulta: `GET /persons?type=Trabalhoso&region=Sul&page=1&size=10`

### Consultar Todas as Pessoas

GET /persons?page={página}&size={tamanho}


- `página`: Número da página (opcional, padrão: 1)
- `tamanho`: Tamanho da página (opcional, padrão: 10)

Exemplo de consulta: `GET /persons?page=1&size=10`


## Contribuindo

Se você deseja contribuir para este projeto, sinta-se à vontade para enviar pull requests ou abrir issues.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE.txt).



