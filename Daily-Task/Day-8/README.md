# Day 8 - Collections Framework Part 2

## Topics Covered

### 1. Map
Map stores data in key-value pairs.

- **HashMap:** Stores key-value pairs and provides fast lookup using keys.
- **LinkedHashMap:** Maintains insertion order.
- **TreeMap:** Stores keys in sorted order.

### 2. Comparable
Comparable is used to define the default sorting order of objects. It uses the `compareTo()` method.

Example: Sorting employees by ID in ascending order.

### 3. Comparator
Comparator is used to define custom sorting rules using methods such as `comparing()`, `reversed()`, and `thenComparing()`.

Example: Sorting employees by salary in descending order and by name when salaries are equal.

### 4. Frequency Counting Using merge()
The `merge()` method updates the count of a value in a Map.

Example: Counting the number of employees in each department.

### 5. equals() and hashCode()
- `equals()` checks whether two objects are logically equal.
- `hashCode()` returns a hash value used by HashMap and HashSet.
- If two objects are equal according to `equals()`, they must have the same hash code.

Forgetting to override `hashCode()` when overriding `equals()` can cause incorrect lookup behavior in hash-based collections.

## Project: Employee Directory

The Employee Directory manages employee information using Java Collections Framework.

### Features
1. Search employees by ID using HashMap.
2. Count employees in each department using `merge()`.
3. Display employees grouped by department using TreeMap.
4. Sort employees by ID using Comparable.
5. Sort employees by salary using Comparator.
6. Display the top 5 highest-paid employees.
7. Demonstrate and fix the missing `hashCode()` bug.

## Learning Outcome

Learned how to store and retrieve data using Maps, sort objects using Comparable and Comparator, count values using `merge()`, and correctly implement the `equals()` and `hashCode()` contract.

## My Console output:

Equals and HashCode Test:
Are employees equal? true
Lookup using equal object: Employee One
Employee Found:
103 Kumar IT 60000.0

Department Frequency:
Sales = 1
HR = 2
IT = 2

Department Report:
HR:
  102 Priya HR 50000.0
  105 Ravi HR 55000.0
IT:
  101 Arun IT 45000.0
  103 Kumar IT 60000.0
Sales:
  104 Divya Sales 40000.0

Employees Sorted by ID:
101 Arun IT 45000.0
102 Priya HR 50000.0
103 Kumar IT 60000.0
104 Divya Sales 40000.0
105 Ravi HR 55000.0

Employees Sorted by Salary and Name:
103 Kumar IT 60000.0
105 Ravi HR 55000.0
102 Priya HR 50000.0
101 Arun IT 45000.0
104 Divya Sales 40000.0

Employees Sorted by Salary:
103 Kumar IT 60000.0
105 Ravi HR 55000.0
102 Priya HR 50000.0
101 Arun IT 45000.0
104 Divya Sales 40000.0

Top 5 Highest-Paid Employees:
103 Kumar IT 60000.0
105 Ravi HR 55000.0
102 Priya HR 50000.0
101 Arun IT 45000.0
104 Divya Sales 40000.0