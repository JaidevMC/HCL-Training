# Library Management System – Frontend

## Overview

The Library Management System is a web application developed using React and Vite. It provides a user-friendly interface to manage books in a library.

The frontend communicates with a Spring Boot backend through REST APIs. The backend stores and retrieves book information from a MySQL database.

## Technologies Used

- **React** – Builds the user interface using reusable components.
- **Vite** – Provides a fast development server and build tool.
- **JavaScript** – Implements frontend logic and functionality.
- **CSS** – Styles the application and provides a responsive layout.
- **Fetch API** – Communicates with the backend REST APIs.
- **Spring Boot** – Handles backend operations and business logic.
- **MySQL** – Stores book information in the database.

## Features

- View all books stored in the database.
- Search books by title, author, or ISBN.
- Filter books by category.
- Add new books to the library.
- Delete books from the library.
- Display book statistics and availability.
- Connect the frontend to the Spring Boot backend.
- Store and retrieve book details using MySQL.


## Frontend and Backend Integration

The frontend sends HTTP requests to the Spring Boot backend using the Fetch API.

Backend API endpoint:

`http://localhost:8080/api/books`

The application uses the following operations:

- **GET** – Retrieves all books.
- **POST** – Adds a new book.
- **DELETE** – Deletes a book using its ID.

The Spring Boot backend communicates with MySQL to store and retrieve book details.

## Application Workflow

1. The user interacts with the React frontend.
2. React sends requests to the Spring Boot REST API.
3. The backend processes the requests using Spring Data JPA.
4. MySQL stores or retrieves the book information.
5. The backend returns the response to React.
6. The frontend updates the displayed book information.

## Development Tools

- Visual Studio Code
- Node.js and npm
- React
- Vite
- Spring Boot
- MySQL Workbench

## Conclusion

This project demonstrates frontend development using React, styling with CSS, REST API integration, and communication with a Spring Boot backend connected to a MySQL database.