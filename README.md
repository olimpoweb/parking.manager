# BackEnd Parking Manager

### Requirements

* Java 17
* Maven 3.8.8
* Spring Boot 3.3.3

### How To Install
1. Clone the repository
2. Run `mvn clean install package -D skipTests`
3. Run `mvn spring-boot:run`

### Configuration
The application can be configured using application.yml (src/resources/application.yml). The following variables are available:
  * `server.port`: The port the application will run on. Default is 8443.
  * `token.signing.key`: Key for crypting the token
  * `config.slots`: The configuration for the parking slots.


### API Reference
The API is documented using Swagger. You can access the documentation at http://localhost:8443/swagger-ui/index.html

### Default Users
- email: admin@admin.com
- password: admin
