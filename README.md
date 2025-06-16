## Endpoints e Permissões
---

### 🔓 Públicos

Rotas públicas que podem ser acessadas por qualquer usuario
- `POST /auth/login`  
  Realiza o login e retorna um token JWT

- `POST /auth/register`  
  Cria um novo usuário

---

### 🔒 Acesso restrito  **ADMIN**

Estas rotas requerem autenticação com um token JWT válido e **só podem ser acessadas por usuários com perfil de administrador**.

- `GET /users`  
  Lista todos os usuários cadastrados.

- `GET /users/{id}`  
  Consulta um usuário específico pelo ID.

- `DELETE /users/{id}`  
  Deleta um usuário específico pelo ID.

- `PUT /users/{id}`  
  Atualiza os dados de um usuário específico.

---

### ✅ Acesso para usuários autenticados (**ADMIN** ou **USER**)

Essas rotas exigem autenticação com token JWT válido e estão disponíveis para **qualquer usuário logado**, seja com perfil de administrador ou usuário comum.

- `GET /users/getCurrent`  
  Retorna os dados do usuário atualmente logado.

- `PUT /users/edit`  
  Atualiza os próprios dados do usuário logado.

---

### ⚠️ Para acessar a aplicação utilize esse local host:
`http://localhost:8080`



