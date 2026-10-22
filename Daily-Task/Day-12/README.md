# Day-12: Assessment-1 – Core Java

## Objective

To develop a menu-driven Student Management System using plain Java and integrate the concepts learned during Days 1–11.

## Features

- Add student records
- View all student records
- Update student details
- Delete student records
- Validate student details
- Handle invalid input and exceptions

## Concepts Used

- Java fundamentals and control statements
- Classes and objects
- Constructors and encapsulation
- Object-oriented design
- ArrayList collection
- CRUD operations
- Exception handling
- Custom exceptions
- Input validation
- Git version control

## Project Structure

- `Main.java` – Menu and user interaction
- `Student.java` – Student data and methods
- `StudentService.java` – Student management operations
- `ValidationException.java` – Custom validation exception

## Testing

Test the application with valid student details, duplicate IDs, invalid marks, missing student IDs, and non-numeric menu input.

## Expected Result

The application should allow users to add, view, update, and delete student records and display clear error messages when an operation fails.

## Git Release

Release tag: `v1.0-core-java`
 
## My Output:

=== Student Management System ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 1
Enter ID: 101
Enter name: Jaidev
Enter department: ECE
Enter mark: 90
Student added successfully.

=== Student Management System ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 2
ID: 101
Name: Jaidev
Department: ECE
Mark: 90.0
--------------------

=== Student Management System ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 3
Enter student ID: 101
Enter new name: Jaidev M C
Enter new department: ECE - 4th Year
Enter new mark: 95
Student updated successfully.

=== Student Management System ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 4
Enter student ID to delete: 101
Student deleted successfully.

=== Student Management System ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 1
Enter ID: 102
Enter name: ABC
Enter department: AAA
Enter mark: 99
Student added successfully.

=== Student Management System ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 2
ID: 102
Name: ABC
Department: AAA
Mark: 99.0
--------------------

=== Student Management System ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 2
ID: 102
Name: ABC
Department: AAA
Mark: 99.0
--------------------

=== Student Management System ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 5
Application closed.