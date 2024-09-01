# Market-Place Application

## Overview

The **Market-Place** application is a Java-based web application designed to facilitate the buying and selling of products. The application allows users to register, list products for sale, browse available products, and securely manage transactions. This project uses **Spring Boot** as the backend framework, **Spring Data JPA** for database interactions, and **MySQL** as the relational database. 

## Features

- **User Authentication**: Secure user registration and login with password encryption.
- **Product Management**: Users can add, update, and delete products.
- **Transaction Management**: Secure transaction processing between buyers and sellers.
- **RESTful API**: Exposes various endpoints to manage users, products, and transactions.
- **Data Persistence**: Utilizes MySQL database for storing user, product, and transaction data.

## Technologies Used

- **Java**: Core programming language.
- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For database interactions.
- **MySQL**: Database management system.
- **Spring Security**: Handles authentication and authorization.
- **Hibernate**: ORM tool for database operations.
- **Gradle**: Build tool for managing dependencies and packaging the application.

## Installation

### Prerequisites

- Java Development Kit (JDK) 17 or higher.
- MySQL server installed and running.
- Gradle installed.

## API Endpoints

### User Management

- `GET /users` - Retrieve all users.
- `GET /users/{id}` - Retrieve a user by ID.
- `POST /users` - Create a new user.
- `PUT /users/{id}` - Update a user by ID.
- `DELETE /users/{id}` - Delete a user by ID.

### Product Management

- `GET /products` - Retrieve all products.
- `GET /products/{id}` - Retrieve a product by ID.
- `POST /products` - Create a new product.
- `PUT /products/{id}` - Update a product by ID.
- `DELETE /products/{id}` - Delete a product by ID.

### Transaction Management

- `GET /transactions` - Retrieve all transactions.
- `POST /transactions` - Process a transaction between a buyer and seller.

## Database Schema

### User Table
```sql
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    dob DATE,
    user_type INT,
    user_status INT,
    date_created DATETIME DEFAULT CURRENT_TIMESTAMP,
    date_updated DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### Products Table
```sql
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    post_description TEXT NOT NULL,
    status INT NOT NULL,
    updated_by INT,
    date_created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_updated DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);
```

### Comments Table
```sql
CREATE TABLE comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    comment_by INT NOT NULL,
    comments TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE,
    FOREIGN KEY (comment_by) REFERENCES user(id) ON DELETE CASCADE
);
```

## Testing

You can use [Postman](https://www.postman.com/) or any other API client to test the endpoints. Simply import the collection and run the requests against your local server.

## Contribution

Contributions are welcome! Please fork the repository and create a pull request to contribute to the project.

## Contact

For any inquiries or support, please contact me via [LinkedIn](https://www.linkedin.com/in/shawonNirob/).
