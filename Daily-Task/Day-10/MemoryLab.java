public class MemoryLab {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Choose an experiment:");
            System.out.println("1 - StackOverflowError");
            System.out.println("2 - OutOfMemoryError");
            System.out.println("3 - String vs StringBuilder");
            System.out.println("4 - Garbage Collection");
            System.out.println("5 - Integer Cache");
            return;
        }

        switch (args[0]) {
            case "1":
                stackOverflow();
                break;

            case "2":
                outOfMemory();
                break;

            case "3":
                stringComparison();
                break;

            case "4":
                garbageCollection();
                break;

            case "5":
                integerCache();
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    // Experiment 1: StackOverflowError
    static void stackOverflow() {
        recursiveMethod(1);
    }

    static void recursiveMethod(int depth) {
        if (depth % 1000 == 0) {
            System.out.println("Recursion depth: " + depth);
        }

        recursiveMethod(depth + 1);
    }

    // Experiment 2: OutOfMemoryError
    static void outOfMemory() {
        java.util.List<byte[]> list = new java.util.ArrayList<>();

        int count = 0;

        while (true) {
            list.add(new byte[1024 * 1024]);
            count++;
            System.out.println("Allocated approximately "
                    + count + " MB");
        }
    }

    // Experiment 3: String vs StringBuilder
    static void stringComparison() {
        int n = 20000;

        long start = System.nanoTime();

        String s = "";

        for (int i = 0; i < n; i++) {
            s += "a";
        }

        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("a");
        }

        long builderTime = System.nanoTime() - start;

        System.out.println("String length: " + s.length());
        System.out.println("String += time: "
                + stringTime / 1_000_000.0 + " ms");

        System.out.println("StringBuilder length: "
                + sb.length());

        System.out.println("StringBuilder time: "
                + builderTime / 1_000_000.0 + " ms");
    }

    // Experiment 4: Garbage Collection
    static void garbageCollection() {
    for (int i = 0; i < 10; i++) {
        byte[] data = new byte[1024 * 1024];

        System.out.println("Created object: "
                + (i + 1) + " MB");

        System.out.println("Array size: "
                + data.length + " bytes");

        data = null;
    }

    System.gc();

    System.out.println("Garbage collection requested.");
}

    // Experiment 5: Integer Cache
    static void integerCache() {
        Integer a = 100;
        Integer b = 100;

        Integer x = 200;
        Integer y = 200;

        System.out.println("100 == 100: " + (a == b));
        System.out.println("200 == 200: " + (x == y));

        System.out.println("200 equals 200: "
                + x.equals(y));
    }
}