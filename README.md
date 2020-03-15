# bookManagement
REST API service for Book Management

Steps to run
1) Clone the repository
2) Open Command Prompt
3) Run `mvn clean install`
4) Once successful, run `mvn spring-boot:run`

 To view H2 console
 `http://localhost:8080/h2
 
APIs exposed :
1) GET `/books` : Find All Present in DB
2) GET `/book/{id}` : Find Book by Book Id
3) POST `/book` : Create a new book entry
4) PUT `/book/{id}` : Update a Book by passing id in Path and Payload in Request Body
5) PUT `/book` : Update a Book by passing entire payload in Request Body
6) DELETE `/book/{id}` : Delete a Book by Id
7) DELETE `/book` : Delete a Book by passing payload in Request Body
