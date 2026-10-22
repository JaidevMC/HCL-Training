# Day-13: Functional Programming

## Objective

To practise functional programming concepts in Java using lambda expressions, functional interfaces, method references, and Stream API operations.

## Features

- Filter products by price, category, and stock availability
- Compose predicates using `and()`, `or()`, and `negate()`
- Transform product names using Function and `andThen()`
- Display products using Consumer
- Create a default product using Supplier
- Define a custom functional interface using `@FunctionalInterface`
- Use method references to simplify lambda expressions

## Concepts Covered

### Lambda Expressions

Provide a concise implementation of a functional interface.

### Predicate

Tests a condition and returns a boolean. Predicates can be combined using `and()`, `or()`, and `negate()`.

### Function

Transforms an input into an output. Function chains can use `andThen()` and `compose()`.

### Consumer

Accepts a value and performs an operation without returning a result.

### Supplier

Provides a value without accepting an input.

### Method References

Simplify suitable lambdas using existing methods and constructors.

### Custom Functional Interface

`ProductCheck` defines a single abstract method for checking a product.

## Expected Result

The program displays filtered products, formatted product names, a default product, affordable products, out-of-stock products, and products from selected categories.

## My Output

=== Filtered Products ===
102 | Mouse | Electronics | Rs.750.0 | In stock: true
104 | Keyboard | Electronics | Rs.1500.0 | In stock: true

=== Formatted Product Names ===
Product: LAPTOP
Product: MOUSE
Product: CHAIR
Product: KEYBOARD
Product: TABLE

=== Default Product ===
106 | Pen | Stationery | Rs.20.0 | In stock: true

=== Affordable Products ===
102 | Mouse | Electronics | Rs.750.0 | In stock: true
104 | Keyboard | Electronics | Rs.1500.0 | In stock: true

=== Out of Stock Products ===
103 | Chair | Furniture | Rs.3500.0 | In stock: false

=== Electronics or Furniture ===
101 | Laptop | Electronics | Rs.55000.0 | In stock: true
102 | Mouse | Electronics | Rs.750.0 | In stock: true
103 | Chair | Furniture | Rs.3500.0 | In stock: false
104 | Keyboard | Electronics | Rs.1500.0 | In stock: true
105 | Table | Furniture | Rs.7000.0 | In stock: true