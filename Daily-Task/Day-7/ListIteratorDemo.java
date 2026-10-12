
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {

        List<String> books = new ArrayList<>();

        books.add("Java");
        books.add("Python");
        books.add("C++");

        System.out.println("Before update: " + books);

        ListIterator<String> it = books.listIterator();

        while (it.hasNext()) {
            String book = it.next();

            if (book.equals("Python")) {
                it.set("Spring Boot");
            }
        }

        System.out.println("After update: " + books);

        System.out.println("Reverse order:");

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }
}
