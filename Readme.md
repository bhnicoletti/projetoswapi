# API SWAPI com login jwt

## Tecnologias Utilizadas
- Spring Boot(Data JPA, WEB, Security, Test)
- Lombok
- H2 Database
- ModelMapper
- JJWT
- Java 11
- Swagger

### Disponivel http://localhost:8080

## Mapeamento de recursos

### /usuarios
- POST -> criar usuario {"login": "usuario", "senha": "senha123456"}
- PATCH -> atualizar senha {"senha": "novasenha"}

### /usuarios/login
- POST -> realizar login após cadastrado {"login": "usuario", "senha": "senha123456"}

### /filmes
- GET -> busca os filmes 
 
### /filmes/{id}
- GET -> busca um único filme

### /pessoas
- GET -> busca as pessoas
- há possibilidade de utilizar paginacao por conter muitos recusos. Ex: "/pessoas/?pag=2"

### /pessoas/{id}
- GET -> busca uma única pessoa

### /planetas
- GET -> busca os planetas
- há possibilidade de utilizar paginacao por conter muitos recusos. Ex: "/planetas/?pag=2"

### /planetas/{id}
- GET -> busca um único planeta

