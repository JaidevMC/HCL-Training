public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentService();

        System.out.println("=== Student Management ===");

        Student s1 = new Student(101, "Arun", "arun@example.com");
        Student s2 = new Student(102, "Priya", "priya@example.com");

        studentService.addStudent(s1);
        studentService.addStudent(s2);

        for (Student student : studentService.getAllStudents()) {
            System.out.println(student);
        }

        System.out.println("Find Student: "
                + studentService.findStudentById(101));

        System.out.println("Student Count: "
                + studentService.getStudentCount());

        System.out.println("Remove Student 102: "
                + studentService.removeStudent(102));

        System.out.println("\n=== Course Management ===");

        CourseRepository repository = new CourseRepository();

        Course c1 = new Course(201, "Java", 8);
        Course c2 = new Course(202, "Spring Boot", 6);

        repository.addCourse(c1);
        repository.addCourse(c2);

        for (Course course : repository.getAllCourses()) {
            System.out.println(course);
        }

        System.out.println("Find Course: "
                + repository.findCourseById(201));

        Course updatedCourse = new Course(201, "Advanced Java", 10);

        System.out.println("Update Course: "
                + repository.updateCourse(updatedCourse));

        System.out.println("Updated Course: "
                + repository.findCourseById(201));

        System.out.println("Delete Course 202: "
                + repository.deleteCourse(202));

        System.out.println("Course Count: "
                + repository.getCourseCount());

        System.out.println("\n=== Validation Test ===");

        try {
            studentService.addStudent(
                    new Student(101, "Duplicate", "dup@example.com"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error handled: " + e.getMessage());
        }
    }
}