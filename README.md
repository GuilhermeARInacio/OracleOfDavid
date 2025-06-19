# Oracle Of David

**Oracle Of David** é uma API desenvolvida em Java 21 com Spring Boot, que utiliza o Ollama rodando localmente com o modelo `gemma:2b` para responder perguntas de forma inteligente.

## Visão Geral

Este sistema funciona como um "oráculo" que recebe perguntas via API REST e retorna respostas geradas pelo modelo de linguagem `gemma:2b`, executado localmente pelo Ollama. A solução combina a robustez do Spring Boot com o poder do modelo de linguagem local para criar um assistente inteligente e rápido, sem depender de serviços externos.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Ollama** (modelo local `gemma:2b`)
- **REST API**

## Requisitos

- Java 21 instalado
- Ollama instalado e configurado localmente
- Modelo `gemma:2b` disponível no Ollama

## Como Executar

1. **Instale o Ollama e baixe o modelo `gemma:2b`:**

   ```bash
   ollama run gemma:2b
   ```

2. **Configure e inicie o Ollama localmente.**

3. **Clone o repositório do Oracle Of David:**

   ```bash
   git clone https://github.com/GuilhermeARInacio/OracleOfDavid.git
   cd OracleOfDavid
   ```

4. **Compile e execute a aplicação Spring Boot:**

   ```bash
   ./mvnw spring-boot:run
   ```

5. **Faça requisições para a API:**

   - Endpoint para enviar perguntas:
     ```
     POST /oracle/chat
     Content-Type: application/json

     {
       "question": "Sua pergunta aqui"
     }
     ```

   - Exemplo de resposta:
     ```json
     {
       "response": "Resposta gerada pelo modelo gemma:2b",
       "model": "gemma:2b"
     }
     ```

## Estrutura da API

| Método | Endpoint     | Descrição                                       |
|--------|--------------|-------------------------------------------------|
| POST   | /oracle/chat | Recebe uma pergunta e retorna a resposta gerada |

## Exemplo de Uso com cURL

```bash
curl -X POST http://localhost:8080/oracle/chat \
  -H "Content-Type: application/json" \
  -d '{"question": "Qual é o sentido da vida?"}'
```

Resposta esperada:

```json
{
  "answer": "O sentido da vida é encontrar propósito e felicidade em suas ações.",
  "model": "gemma:2b"
}
```

## Configurações

A aplicação pode ser configurada através do arquivo `application.properties` para definir portas, conexões e integrações com o Ollama, caso necessário.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença

[MIT License](LICENSE)
