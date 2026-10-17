Day-10: Project Review and Memory Pitfalls

Objective

To review common memory management problems in Java and understand stack and heap memory using a business method.

1. Growing Static Collections

Static collections can retain objects throughout the lifetime of an application. Continuously adding objects without removing unnecessary entries can increase memory usage.

Solution:
Remove unnecessary entries and limit collection growth when appropriate.

2. Unclosed Resources

Files, streams, and database connections can consume resources when they are not closed properly.

Solution:
Use try-with-resources to close supported resources automatically.

3. String Concatenation in Loops

Repeatedly using String += inside a loop creates intermediate strings and can increase memory usage and execution time.

Solution:
Use StringBuilder and its append() method.

4. Integer Cache

The == operator compares references when used with Integer objects. It does not reliably compare their numeric values.

Solution:
Use equals() to compare Integer values.

5. Unnecessary Object References

Objects that remain reachable through collections or static variables cannot be reclaimed by garbage collection.

Solution:
Remove unnecessary references when the objects are no longer required.

Stack and Heap Diagram

Business method: processOrder()

Stack Memory

main()
orderId = 101
order reference

processOrder()
quantity = 2
price = 500
total = 1000

Heap Memory

Order Object
orderId = 101
quantity = 2
total = 1000

Explanation

The stack stores method-call frames, local primitive variables, and object references.

The heap stores objects and arrays created during execution.

When processOrder() finishes, its stack frame is removed. The Order object can be reclaimed by garbage collection only when no live references can reach it.