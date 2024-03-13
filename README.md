# Microserviço Spring Boot com Java Email Sender e Gmail SMTP

Este repositório contém um microsserviço desenvolvido em Spring Boot, que utiliza a biblioteca Lombok para simplificar a criação de classes Java, e integra o envio de emails utilizando o Java Email Sender com o Gmail SMTP.

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado em sua máquina:

- Java 17 ou superior
- Maven
- Uma conta de email do Gmail (será utilizada para enviar os emails)
- Credenciais de acesso à conta de email (endereço de email e senha de 16 dígitos)

## Configuração

1. Clone este repositório: https://github.com/Cleverton-Rocha/email-microservice-java
2. Abra o projeto em sua IDE de preferência.
3. Você deve criar uma senha de 16 dígitos pro seu email seguindo esse [TUTORIAL](https://support.google.com/accounts/answer/185833)
4. Configure as credenciais do Gmail no arquivo `application.properties`:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seu-email@gmail.com
spring.mail.password=sua-senha-16-digitos
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

## Usando o serviço
1. Mande uma requisição `POST` para `localhost:8080/mail/send`
2. O corpo da requisição deve conter:
```json
{
  "emailTo": "destinatario@example.com",
  "subject": "Assunto do Email",
  "message": "Corpo do Email"
}
```
3. Você deve obter um `status code 201` com a resposta sendo "SENT" para email enviado com sucesso.  
4. Você deve obter um `status code 402` com a resposta sendo "NOT_SENT" para email não enviado.
