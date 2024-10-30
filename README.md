

# LifesparkTech

LifesparkTech is a Spring Boot application that provides a RESTful API for user authentication and registration using JWT (JSON Web Tokens) for security and MongoDB for data storage and allows you to perform various HTTP requests.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Security](#security)
- [Testing](#testing)
- [Screenshots](#screenshots)
- [Contributing](#contributing)

## Features

- User registration with password hashing using BCrypt.
- User authentication with JWT.
- MongoDB integration for data persistence.
- RESTful API design.
- Spring Security for securing endpoints.
- Detailed logging for debugging and monitoring.

## Requirements

- Java 17 or higher
- Maven 3.6 or higher
- MongoDB 4.0 or higher

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/lifesparkTech.git
   cd lifesparkTech
   ```

2. **Build the project:**

   Use Maven to build the project:

   ```bash
   mvn clean install
   ```

## Configuration

### MongoDB

Ensure MongoDB is running on your local machine or update the `application.properties` file with your MongoDB server details:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=lifesparktech
spring.data.mongodb.auto-index-creation=true
```

### JWT Secret

Set a secure JWT secret in `application.properties`:

```properties
jwt.secret=your-256-bit-secret-key-here-make-it-long-and-secure
```

### Server Port

The application is configured to run on port 3000. You can change this in `application.properties`:

```properties
server.port=3000
```

## Running the Application

Start the application using Maven:

```bash
mvn spring-boot:run
```

Or, if you prefer, build the JAR and run it:

```bash
java -jar target/lifesparkTech-0.0.1-SNAPSHOT.jar
```

## API Endpoints

### Authentication

- **Register a new user:**

  ```
  POST /api/auth/register
  ```

  **Request Body:**

  ```json
  {
    "username": "yourUsername",
    "password": "yourPassword"
  }
  ```

- **Login and obtain JWT:**

  ```
  POST /api/auth/login
  ```

  **Request Body:**

  ```json
  {
    "username": "yourUsername",
    "password": "yourPassword"
  }
  ```

  **Response:**

  ```json
  {
    "token": "your.jwt.token"
  }
  ```

## Security

- The application uses Spring Security to secure endpoints.
- JWT is used for stateless authentication.
- Passwords are hashed using BCrypt before storing in the database.

## Testing

Run tests using Maven:

```bash
mvn test
```
## Screenshots

Some screenshots of the working project
![img1](https://github.com/user-attachments/assets/32e81328-d069-4c5d-bd7d-46104837352c)
![img2](https://github.com/user-attachments/assets/4a003c5a-faf0-4f4f-9534-9eed77836d56)
![img3](https://github.com/user-attachments/assets/d6449051-b49a-45be-854b-2fdb538b416b)
![img4](https://github.com/user-attachments/assets/6a46ec19-12d2-4a07-a56b-44b2de69fd3e)
![img5](https://github.com/user-attachments/assets/bc25bdaa-1fdd-4ee0-a657-99ddb17013f1)



## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.


