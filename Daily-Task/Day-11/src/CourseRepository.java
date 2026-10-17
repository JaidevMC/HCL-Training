import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRepository {
    private final Map<Integer, Course> courses = new HashMap<>();

    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException(
                    "Course cannot be null");
        }

        if (courses.containsKey(course.getId())) {
            throw new IllegalArgumentException(
                    "Course ID already exists");
        }

        courses.put(course.getId(), course);
    }

    public Course findCourseById(int id) {
        return courses.get(id);
    }

    public boolean updateCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException(
                    "Course cannot be null");
        }

        if (!courses.containsKey(course.getId())) {
            return false;
        }

        courses.put(course.getId(), course);
        return true;
    }

    public boolean deleteCourse(int id) {
        return courses.remove(id) != null;
    }

    public List<Course> getAllCourses() {
        return Collections.unmodifiableList(
                new ArrayList<>(courses.values()));
    }

    public int getCourseCount() {
        return courses.size();
    }
}