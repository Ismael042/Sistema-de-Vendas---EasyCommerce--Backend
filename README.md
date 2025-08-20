# 🛒 Sistema de Vendas - EasyCommerce (Backend)

Sistema backend para gerenciamento de vendas, desenvolvido com **Java 17** e **Spring Boot**.  
O projeto implementa autenticação com JWT, operações CRUD e integração com banco de dados MySQL.  
Também está estruturado para ser consumido por um **frontend (React ou qualquer cliente REST)**, com configuração de CORS habilitada.

---

## 🚀 Tecnologias utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA / Hibernate**
- **Spring Security (JWT)**
- **MySQL**
- **Maven**
- **Documentação | Postman**

---

## ⚙️ Funcionalidades
- Cadastro, edição e exclusão de **clientes**
- Cadastro, edição e exclusão de **produtos**
- Registro e listagem de **vendas**
- Autenticação e autorização de usuários (JWT)
- Configuração de **CORS** para integração com frontend

---

## 📂 Estrutura de pacotes
```
com.ismael.easycommerce
 ├── config        # Configurações de segurança e CORS
 ├── controller    # Endpoints REST
 ├── model         # Entidades JPA
 ├── repository    # Interfaces do Spring Data
 ├── service       # Lógica de negócios
 └── SistemaDeVendasEasyCommerceApplication.java # Classe principal
```

---

## ▶️ Como executar o projeto
1. Clone este repositório:
   ```bash
   git clone https://github.com/seuusuario/sistema-de-vendas.git
   ```
2. Acesse o diretório do backend:
   ```bash
   cd sistema-de-vendas/backend
   ```
3. Configure o banco de dados no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/sistema_vendas
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```
4. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

---

## 📮 Coleção Postman

Para facilitar os testes da API, há uma coleção do **Postman** pronta para uso, contendo todos os endpoints configurados (clientes, produtos, vendas e usuários).

### 🔗 Acessar
Você pode baixar/importar diretamente o arquivo da coleção disponível no repositório:

- [📥 Baixar coleção Postman](./docs/easyecomerce.postman_collection.json)

Ou abrir diretamente pelo link compartilhado:  
[➡ Clique aqui para abrir no Postman](https://postman.co/workspace/My-Workspace~2dd3f149-bacd-41d5-822d-1f1439937944/collection/42413279-5b2da8e7-260e-4d29-a17c-8f8778f94f0c?action=share&creator=42413279)

### 📌 Como importar no Postman
1. Abra o **Postman**
2. Clique em **Import**
3. Escolha **File** e selecione o arquivo `easyecomerce.postman_collection.json`
4. Pronto! Agora é só executar as requisições.

---

## 🌐 Integração com Frontend
Este backend foi desenvolvido para ser consumido por um frontend em **React** ou qualquer cliente REST.

A API possui:
- Endpoints documentados com Postman
- Configuração de CORS para permitir acesso a partir do frontend
- Estrutura de autenticação JWT para login e gerenciamento de sessão

### Exemplo de consumo em React
```javascript
fetch("http://localhost:8080/produtos", {
  headers: {
    "Authorization": "Bearer <seu_token>"
  }
})
  .then(res => res.json())
  .then(data => console.log(data));
```

## 👨‍💻 Autor
**Ismael Santana**  
[LinkedIn](https://www.linkedin.com/in/Ismael-Santana-) | [GitHub](https://github.com/Ismael042)
