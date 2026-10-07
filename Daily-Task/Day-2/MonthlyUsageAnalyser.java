public class MonthlyUsageAnalyser {

    public static void main(String[] args) {

        int[] usage = {
            120, 150, 100, 200,
            180, 220, 250, 190,
            170, 210, 230, 260
        };

        long total = 0;
        int max = usage[0];
        int min = usage[0];

        for (int i = 0; i < usage.length; i++) {

            total = total + usage[i];

            if (usage[i] > max) {
                max = usage[i];
            }

            if (usage[i] < min) {
                min = usage[i];
            }
        }

        double average = (double) total / usage.length;

        char grade = average >= Constants.HIGH_LIMIT ? 'A'
                   : average >= Constants.MEDIUM_LIMIT ? 'B'
                   : 'C';

        System.out.println("Total Usage: " + total);
        System.out.println("Average Usage: " + average);
        System.out.println("Maximum Usage: " + max);
        System.out.println("Minimum Usage: " + min);
        System.out.println("Grade: " + grade);

        int[][] houses = {
            {100, 120, 150},
            {200, 180, 220},
            {150, 170, 190}
        };

        System.out.println("\nHouse Usage:");

        for (int i = 0; i < houses.length; i++) {

            System.out.print("House " + (i + 1) + ": ");

            for (int j = 0; j < houses[i].length; j++) {
                System.out.print(houses[i][j] + " ");
            }

            System.out.println();
        }
    }
}