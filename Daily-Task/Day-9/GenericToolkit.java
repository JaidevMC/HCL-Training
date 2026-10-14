public class GenericToolkit {

    // Generic class with two different types
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void display() {
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        }
    }

    // Bounded generic class: accepts Number types only
    static class Box<T extends Number> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public void display() {
            System.out.println("Box Value: " + value);
        }
    }

    // Find maximum using Comparable
    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    // Upper-bounded wildcard: reads numbers
    public static double sum(java.util.List<? extends Number> list) {
        double total = 0;

        for (Number n : list) {
            total += n.doubleValue();
        }

        return total;
    }

    // Lower-bounded wildcard: accepts Integer values
    public static void addNumbers(
            java.util.List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }

    // Custom AutoCloseable resource
    static class MyResource implements AutoCloseable {
        private String name;

        public MyResource(String name) {
            this.name = name;
            System.out.println(name + " opened");
        }

        @Override
        public void close() {
            System.out.println(name + " closed");
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Pair Example ===");
        Pair<Integer, String> pair =
                new Pair<>(101, "Laptop");
        pair.display();

        System.out.println("\n=== Box Example ===");
        Box<Integer> box = new Box<>(100);
        box.display();

        System.out.println("\n=== Maximum Example ===");
        System.out.println("Maximum: " + max(25, 50));
        System.out.println("Maximum: " + max("Apple", "Mango"));

        System.out.println("\n=== Upper Wildcard Example ===");
        java.util.List<Integer> numbers =
                java.util.List.of(10, 20, 30);
        System.out.println("Sum: " + sum(numbers));

        System.out.println("\n=== Lower Wildcard Example ===");
        java.util.List<Number> values =
                new java.util.ArrayList<>();
        addNumbers(values);
        System.out.println("Values: " + values);

        System.out.println("\n=== Try-with-resources Example ===");
        try (MyResource first = new MyResource("Resource 1");
             MyResource second = new MyResource("Resource 2")) {
            System.out.println("Inside try block");
        }
    }
}