Day-7: Collections Framework — Timing Results

1. Objective

To compare the performance of ArrayList and LinkedList for adding elements at the end and accessing elements using get(i).

2. Test Details

Language: Java

Number of elements: 100,000

Measurement method: System.nanoTime()

Collections tested: ArrayList and LinkedList

3. Timing Results

Operation | ArrayList (ns) | LinkedList (ns)

Add at end | 5,147,000 | 4,175,999

Indexed access (get(i)) | 1,495,901 | 3,379,259,000

4. Analysis

Adding Elements

In this test, LinkedList took less time than ArrayList to add 100,000 elements at the end. However, the result may vary depending on JVM warm-up, memory allocation, and system activity.

Indexed Access

ArrayList performed much faster than LinkedList when accessing elements using get(i).

ArrayList provides typically constant-time indexed access, O(1).

LinkedList requires traversal to reach an indexed element, O(n).

Repeatedly accessing every index in a LinkedList makes the complete loop O(n²).

5. Conclusion

ArrayList is suitable when frequent indexed access is required, such as retrieving books from a library catalogue. LinkedList can be useful for insertions or removals when the required position is already available through an iterator.

The measurements represent one run and should not be treated as universal performance benchmarks.

6. Verification

The Java program compiled and executed successfully. The timing values above were recorded from the terminal output.