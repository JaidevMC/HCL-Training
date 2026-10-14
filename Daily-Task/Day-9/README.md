# Day-9: Generics

## Topics Covered

- Generic classes and methods
- Bounded type parameters
- Type erasure
- Upper-bounded and lower-bounded wildcards
- PECS principle
- try-with-resources
- AutoCloseable interface
- Generic CRUD repository
- CSV file handling

## GenericToolkit

Demonstrates Pair<K,V>, Box<T extends Number>,
the max() generic method, wildcards, and automatic
resource closing.

## Generic Repository

CrudRepository<T, ID> defines common CRUD operations.

InMemoryRepository<T, ID> implements the operations
using a HashMap and can be reused for different entities.

ProductRepository loads product data from a CSV file
and demonstrates create, read, update, and delete operations.

## Key Concepts

- Generics provide type safety and code reuse.
- Bounded types restrict the permitted data types.
- PECS means Producer Extends, Consumer Super.
- try-with-resources automatically closes resources.
- Type erasure removes most generic type information
  during compilation.

  ## My console Output
  === All Products ===
101 Laptop 55000.0
102 Mouse 750.0
103 Keyboard 1500.0
104 Monitor 12000.0
105 Headphones 2500.0

=== Find Product ===
102 Mouse 750.0

=== Update Product ===
Updated: true
102 Wireless Mouse 1200.0

=== Delete Product ===
Deleted: true

=== Final Products ===
101 Laptop 55000.0
102 Wireless Mouse 1200.0
103 Keyboard 1500.0
104 Monitor 12000.0