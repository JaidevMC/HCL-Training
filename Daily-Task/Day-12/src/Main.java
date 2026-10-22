
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        int choice = 0;

        do {
            try {
                System.out.println("\n=== Student Management System ===");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter department: ");
                        String department = sc.nextLine();

                        System.out.print("Enter mark: ");
                        double mark = Double.parseDouble(sc.nextLine().trim());

                        service.addStudent(
                            new Student(id, name, department, mark)
                        );
                        break;

                    case 2:
                        service.viewStudents();
                        break;

                    case 3:
                        System.out.print("Enter student ID: ");
                        int updateId = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new department: ");
                        String newDepartment = sc.nextLine();

                        System.out.print("Enter new mark: ");
                        double newMark =
                            Double.parseDouble(sc.nextLine().trim());

                        service.updateStudent(
                            updateId, newName, newDepartment, newMark
                        );
                        break;

                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        int deleteId = Integer.parseInt(sc.nextLine().trim());

                        service.deleteStudent(deleteId);
                        break;

                    case 5:
                        System.out.println("Application closed.");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (ValidationException e) {
                System.out.println("Validation error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
