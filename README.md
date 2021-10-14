# Validate Password API
Java Rest API-  Validate Password

![image](https://securityintelligence.com/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2018/10/si-eight-character-password-feature-630x330.jpg.webp)

**[![CircleCI](https://circleci.com/gh/ramoonpereira/hermes.svg?style=shield)](https://circleci.com/gh/ramoonpereira/hermes)**

## Requisitos - Dev - Para desenvolvimento
```sh
Java 11
Docker/Docker Compose
Maven
IDE (IntelliJ)
```

## Import CodeStyle - Pattern Google Check Style
```sh
/src/main/resources/code_style.xml
```

## Executando projeto - Jar
```sh
mvn clean install
java -jar target/password.validate-0.0.1-SNAPSHOT.jar
```

## Executando projeto - Docker
```sh
docker-compose up -d
```

## Executando Sonar 
```sh
mvn clean install sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.projectKey=validate-password-api -Dsonar.projectName=validate-password-api -Dsonar.sources=src/main/java -Dsonar.sourceEncoding=UTF-8 -Dsonar.exclusions='target/**' -Dsonar.java.binaries=target
```

## WEB API

**Recursos disponiveis:**

| Rota | Versão |Descrição | HTTP Method |
| -- | -- | -- | -- | -- |
| /swagger-ui.html | v1 |Interface para documentação da API| GET |
| /v1/validatepassword | v1 | Método para validar uma senha | POST |


# Validação

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
    - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

# Utilização
-Recurso: http://localhost:8080
```curl
Exemplo de chamada feita via Postman:
curl --location --request POST 'http://localhost:8080/v1/validatepassword' \
--header 'Content-Type: application/json' \
--data-raw '{
"password":"AbTp9!fok"
}'
```
Resposta:
```json
{
    "valid": true
}
```

> **_Nota:_**  Os recursos poderão ser testado via interface -> http://localhost:8080/swagger-ui.html 