
import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) throws ValidationException {
        if (student.getId() <= 0) {
            throw new ValidationException("ID must be positive.");
        }

        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new ValidationException("Name cannot be empty.");
        }

        if (student.getDepartment() == null ||
            student.getDepartment().trim().isEmpty()) {
            throw new ValidationException("Department cannot be empty.");
        }

        if (student.getMark() < 0 || student.getMark() > 100) {
            throw new ValidationException("Mark must be between 0 and 100.");
        }

        for (Student s : students) {
            if (s.getId() == student.getId()) {
                throw new ValidationException("Student ID already exists.");
            }
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    public void updateStudent(int id, String name,
                              String department, double mark)
                              throws ValidationException {
        Student student = findStudent(id);

        if (student == null) {
            throw new ValidationException("Student ID not found.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("Name cannot be empty.");
        }

        if (department == null || department.trim().isEmpty()) {
            throw new ValidationException("Department cannot be empty.");
        }

        if (mark < 0 || mark > 100) {
            throw new ValidationException("Mark must be between 0 and 100.");
        }

        student.setName(name);
        student.setDepartment(department);
        student.setMark(mark);

        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int id) throws ValidationException {
        Student student = findStudent(id);

        if (student == null) {
            throw new ValidationException("Student ID not found.");
        }

        students.remove(student);
        System.out.println("Student deleted successfully.");
    }

    private Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }
}
