
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTiming {
    public static void main(String[] args) {

        int size = 100000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Measure adding items at the end
        long start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }

        long arrayAddTime = System.nanoTime() - start;

        start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }

        long linkedAddTime = System.nanoTime() - start;

        // Measure indexed access
        start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            arrayList.get(i);
        }

        long arrayGetTime = System.nanoTime() - start;

        start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            linkedList.get(i);
        }

        long linkedGetTime = System.nanoTime() - start;

        System.out.println("Operation timings (nanoseconds)");
        System.out.println("ArrayList add: " + arrayAddTime);
        System.out.println("LinkedList add: " + linkedAddTime);
        System.out.println("ArrayList get(i): " + arrayGetTime);
        System.out.println("LinkedList get(i): " + linkedGetTime);
    }
}
