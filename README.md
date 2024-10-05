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
create table users
(
    id         int auto_increment
        primary key,
    username   varchar(50)                           not null,
    password   varchar(100)                          not null,
    email      varchar(100)                          not null,
    role       varchar(20) default 'USER'            not null,
    created_at timestamp   default CURRENT_TIMESTAMP null,
    updated_at timestamp   default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint email
        unique (email),
    constraint username
        unique (username)
);
```

### Products Table
```sql
create table products
(
    id          int auto_increment
        primary key,
    name        varchar(100)                        not null,
    description text                                null,
    price       decimal(10, 2)                      not null,
    seller_id   int                                 not null,
    created_at  timestamp default CURRENT_TIMESTAMP null,
    updated_at  timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint products_ibfk_1
        foreign key (seller_id) references users (id)
            on delete cascade
);
```

### Transaction Table
```sql
create table transactions
(
    id               int auto_increment
        primary key,
    product_id       int                                 not null,
    buyer_id         int                                 not null,
    transaction_date timestamp default CURRENT_TIMESTAMP null,
    amount           decimal(10, 2)                      not null,
    constraint transactions_ibfk_1
        foreign key (product_id) references products (id)
            on delete cascade,
    constraint transactions_ibfk_2
        foreign key (buyer_id) references users (id)
            on delete cascade
);
```

## Testing

You can use [Postman](https://www.postman.com/) or any other API client to test the endpoints. Simply import the collection and run the requests against your local server.

## Contribution

Contributions are welcome! Please fork the repository and create a pull request to contribute to the project.

## Contact

For any inquiries or support, please contact me via [LinkedIn](https://www.linkedin.com/in/shawon-sarowar/).
