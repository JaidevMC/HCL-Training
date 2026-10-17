Day-10: Memory Management

Overview

This task explores Java memory management through five experiments involving stack memory, heap memory, string concatenation, garbage collection, and the Integer cache.

1. Stack vs Heap

Stack memory stores method-call frames and local variables. Each method call creates a stack frame that is removed when the method returns.

Heap memory stores objects and arrays. Objects that are no longer reachable can be reclaimed by garbage collection.

2. StackOverflowError

StackOverflowError occurs when a thread's stack cannot accommodate further method calls. Excessive recursion is a common cause.

The -Xss option changes the thread stack size. Testing different values helps demonstrate how stack size affects recursion depth.

3. OutOfMemoryError

OutOfMemoryError can occur when the JVM cannot allocate an object because sufficient heap memory is unavailable.

The -Xmx64m option limits the maximum heap size to approximately 64 MB. Retaining allocated arrays in a collection prevents those arrays from being reclaimed while they remain reachable.

4. String vs StringBuilder

Strings are immutable. Repeated concatenation can create many intermediate string objects.

StringBuilder provides a mutable sequence of characters and is generally more efficient for repeated string modifications.

The experiment compares the execution times of both approaches.

5. Garbage Collection

Garbage collection automatically reclaims memory used by eligible objects.

The -Xlog:gc option displays garbage collection logs. System.gc() requests garbage collection but does not guarantee immediate execution.

6. Integer Cache

Java caches certain Integer values, including values from -128 to 127 under the default configuration.

The == operator compares object references, whereas equals() compares the values of Integer objects.

Common Memory Pitfalls

Growing static collections can retain unnecessary objects.

Unclosed files and streams can waste system resources.

Repeated string concatenation in loops can create unnecessary intermediate objects.

Using == to compare wrapper objects can produce unexpected results.

Keeping unnecessary object references can prevent garbage collection.