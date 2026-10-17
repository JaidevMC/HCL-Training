Day-11: AI Usage Report

Objective

To document how AI assistance was used to generate Java code and how the generated code was reviewed and improved.

Entry 1: Student POJO

Vague prompt:

Create a Student class in Java.

Specific prompt:

Create a Student POJO with private fields for ID, name, and email. Add a constructor, getters, setters, input validation, equals(), hashCode(), and toString(). Use student ID for equality.

Generated code:

A Student class containing fields, a constructor, and methods.

Review performed:

Checked encapsulation, null handling, validation, and equality implementation.

Changes made:

Made fields private, added validation, and implemented equals() and hashCode().

Entry 2: StudentService

Prompt:

Create a StudentService class that adds, finds, removes, and lists students. Prevent duplicate student IDs, reject null inputs, and protect the internal collection.

Generated code:

A service class that manages Student objects.

Review performed:

Checked duplicate IDs, null handling, collection exposure, and return values.

Changes made:

Added duplicate ID checks, null validation, and an unmodifiable copy of the student list.

Entry 3: Course Entity and Repository

Prompt:

Create a Course POJO and a CourseRepository using HashMap. Include validation, add, find, update, delete, and list operations. Prevent duplicate course IDs and protect the internal collection.

Generated code:

Course.java and CourseRepository.java.

Review performed:

Checked field validation, duplicate IDs, collection choice, and repository operations.

Changes made:

Added validation, used HashMap for ID-based lookup, and returned an unmodifiable list copy.

Overall Learning

AI helps generate Java boilerplate code quickly. However, generated code must be reviewed for correctness, encapsulation, null handling, collection safety, equals() and hashCode(), and exception handling.

AI-generated code should be tested before it is considered complete.