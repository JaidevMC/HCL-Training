# Day 4 – OOP Concepts and Debugging

## Objective

Learn core Java OOP concepts and practice debugging using VS Code.

## Topics Covered

- Classes and Objects
- Fields and Methods
- Constructors
- Constructor Overloading
- Constructor Chaining using `this()`
- `this` keyword
- `super` keyword
- Encapsulation
- Static and Instance Members
- Access Modifiers
- Packages
- Breakpoints
- Conditional Breakpoints
- Step Into
- Step Over
- Step Out
- Watch Variables
- Call Stack
- Hot Code Replace

## Implementation

Created a `BankAccount` class with:

- Private fields
- Static account counter
- Three overloaded constructors
- Constructor chaining using `this()`
- Deposit and withdrawal validation
- `equals()` and `hashCode()`

## OOP Concepts

### Encapsulation
Used private fields with public methods to control access to account data.

### Constructor Overloading
Implemented multiple constructors with different parameters.

### Constructor Chaining
Used `this()` to call another constructor of the same class.

### Static vs Instance
Used a static counter for generating account numbers and instance fields for account-specific data.

### Access Modifiers
Demonstrated:

- `public`
- `private`
- `protected`
- default

### Inheritance and super
Used a parent and child class to demonstrate `super()` and `super.method()`.

## Debugging

A bug was intentionally introduced in the `withdraw()` method:

```java
balance += amount;