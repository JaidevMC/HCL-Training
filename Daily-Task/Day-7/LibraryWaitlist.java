import java.util.*;

public class LibraryWaitlist {

    public static void main(String[] args) {

        List<String> catalogue = new ArrayList<>();
        catalogue.add("Java");
        catalogue.add("Python");
        catalogue.add("Java");

        System.out.println("Catalogue: " + catalogue);

        Set<String> students = new LinkedHashSet<>();
        students.add("S101");
        students.add("S102");
        students.add("S101");

        System.out.println("Students: " + students);

        Queue<String> waitlist = new ArrayDeque<>();
        waitlist.offer("Arun");
        waitlist.offer("Priya");
        waitlist.offer("Kavi");

        System.out.println("Waitlist: " + waitlist);
        System.out.println("Next student: " + waitlist.peek());

        System.out.println("Served: " + waitlist.poll());
        System.out.println("Updated waitlist: " + waitlist);

        PriorityQueue<String> priorityQueue =
                new PriorityQueue<>(
                    Comparator.comparingInt(
                        s -> Integer.parseInt(s.split("-")[0])
                    )
                );

        priorityQueue.offer("2-Student: Arun");
        priorityQueue.offer("1-Faculty: Kumar");
        priorityQueue.offer("2-Student: Priya");

        System.out.println("Priority service order:");

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}