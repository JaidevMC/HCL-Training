
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class OverdueItems {
    public static void main(String[] args) {

        List<Integer> overdueDays = new ArrayList<>(
            Arrays.asList(2, 10, 4, 15, 8, 20)
        );

        System.out.println("Before removing: " + overdueDays);

        Iterator<Integer> it = overdueDays.iterator();

        while (it.hasNext()) {
            int days = it.next();

            if (days > 7) {
                it.remove();
            }
        }

        System.out.println("After removing: " + overdueDays);
    }
}
