import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null");
        }

        if (findStudentById(student.getId()) != null) {
            throw new IllegalArgumentException(
                    "Student ID already exists");
        }

        students.add(student);
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean removeStudent(int id) {
        Student student = findStudentById(id);

        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(
                new ArrayList<>(students));
    }

    public int getStudentCount() {
        return students.size();
    }
}