📚 Library Management System

• Project Description

- A web-based application designed to digitize and simplify college library operations.
- Manages books, book copies, members, issue and return operations, reservations, fines, and reports.
- Provides a searchable Online Public Access Catalog (OPAC) for students and faculty.

• Objectives

- Digitize college library operations.
- Manage books and individual book copies.
- Simplify book issue and return.
- Automatically calculate overdue fines.
- Allow members to reserve unavailable books.
- Provide book search and filtering.
- Maintain borrowing and fine history.
- Generate library reports.

• User Roles

- Student – Search books, borrow books, reserve unavailable books, and view borrowing history and fines.
- Faculty – Search and borrow books based on faculty policies.
- Librarian – Manage books and copies, issue and return books, manage reservations and reports.
- Admin – Manage users, policies, and export reports.

• Key Features

- Book Management
  - Add, edit, and retire books.
  - Manage ISBN, author, and category.
  - Track individual copies using unique barcodes.

- Issue and Return
  - Issue available book copies to eligible members.
  - Automatically calculate due dates.
  - Track loan history.
  - Update book-copy availability.

- Book Reservation
  - Reserve books when all copies are unavailable.
  - Maintain a reservation queue.

- Fine Management
  - Automatically calculate fines for late returns.
  - Apply different fine rules for different member types.
  - Track pending fines and payments.
  - Configure fine rules without changing application code.

- OPAC Search
  - Search books by title, author, ISBN, and category.
  - Support filtering and pagination.

- Overdue Alerts
  - Identify overdue books.
  - Notify members about overdue books.
  - Support bulk overdue notifications.

- Reports
  - Most borrowed books.
  - Overdue books.
  - Fine collection.
  - Borrowing history.
  - Export overdue reports.

• Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- Spring Cloud OpenFeign
- REST APIs
- MySQL / PostgreSQL
- Maven
- Git & GitHub
- Postman

• Java Concepts Used

- Object-Oriented Programming
- Strategy Pattern – Fine calculation based on member type.
- Factory Pattern – Member policy selection.
- Builder Pattern – Loan receipt creation.
- Java Records – Book summary data.
- Sealed Types – Book-copy status.
- Streams – Finding top borrowed books.
- CompletableFuture – Asynchronous overdue notifications.
- Optional – Safe member lookup.

• REST APIs

- GET /api/v1/books?q=&page= – Search books
- POST /api/v1/loans – Issue a book
- PUT /api/v1/loans/{id}/return – Return a book
- POST /api/v1/reservations – Reserve a book

• Main Data Entities

- Book
- Book Copy
- Author
- Category
- Member
- Loan
- Reservation
- Fine
- Payment
- User

• Non-Functional Requirements

- Atomic issue operation – Book-copy status and loan record must be updated in one transaction.
- Performance – Catalog search should achieve p95 response time below 400 ms for approximately 50,000 books.
- Configurable fine rules – Fine policies should be externalized and configurable.
- Audit logging – Every book issue and return operation should be recorded.

• Main Workflow

- Book Issue
  - Member
  - Eligibility Check
  - Borrowing Limit
  - Copy Availability
  - Loan Creation
  - Copy Status Update

- Book Return
  - Return Book
  - Due Date Check
  - Fine Calculation
  - Loan Update
  - Copy Status Update
  - Reservation Processing

• Project Status

- Under Development
- The project is being developed using Java and Spring Boot.

• Purpose

- Developed for academic and learning purposes.
- Provides practical experience in Java backend development, Spring Boot, REST APIs, database management, OOP, design patterns, and microservice communication.