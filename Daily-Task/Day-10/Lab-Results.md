Day-10: Memory Management Lab Results

Objective

To understand Java memory management through five experiments involving stack memory, heap memory, string handling, garbage collection, and the Integer cache.

Experiment 1: StackOverflowError

Commands tested:
java -Xss256k MemoryLab 1
java -Xss512k MemoryLab 1
java -Xss1m MemoryLab 1

Observation:
All three runs produced StackOverflowError. The recursion depth varied depending on the stack size and JVM environment.

Results:
256 KB: Record the last printed recursion depth.
512 KB: Record the last printed recursion depth.
1 MB: Record the last printed recursion depth.

Conclusion:
A larger stack generally allows more recursive calls before StackOverflowError occurs.

Experiment 2: OutOfMemoryError

Command:
java -Xmx64m MemoryLab 2

Observation:
The program allocated byte arrays and stored them in a list. The program eventually produced OutOfMemoryError because the heap memory was exhausted.

Conclusion:
Keeping references to too many objects can exhaust available heap memory.

Experiment 3: String vs StringBuilder

Command:
java MemoryLab 3

Observation:
Both methods produced strings of the same length. StringBuilder is generally faster than repeated String concatenation using += in a loop.

Results:
String += time: Record the actual execution time in milliseconds.
StringBuilder time: Record the actual execution time in milliseconds.

Conclusion:
StringBuilder is more efficient for repeated string modifications.

Experiment 4: Garbage Collection

Command:
java -Xlog:gc MemoryLab 4

Observation:
The program created byte arrays, removed their references, and requested garbage collection using System.gc(). Garbage collection logs appeared when collection events occurred.

Conclusion:
Garbage collection reclaims memory occupied by eligible objects. System.gc() requests collection but does not guarantee immediate execution.

Experiment 5: Integer Cache

Command:
java MemoryLab 5

Expected output:

100 == 100: true
200 == 200: false
200 equals 200: true

Observation:
The default Integer cache includes values from -128 to 127. The == operator compares object references, whereas equals() compares values.

Conclusion:
Use equals() to compare Integer object values.