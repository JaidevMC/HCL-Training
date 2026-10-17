import java.util.Objects;

public class Course {
    private int id;
    private String name;
    private int durationInWeeks;

    public Course(int id, String name, int durationInWeeks) {
        setId(id);
        setName(name);
        setDurationInWeeks(durationInWeeks);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Course ID must be positive");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Course name cannot be empty");
        }
        this.name = name.trim();
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        if (durationInWeeks <= 0) {
            throw new IllegalArgumentException(
                    "Duration must be positive");
        }
        this.durationInWeeks = durationInWeeks;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Course)) {
            return false;
        }

        Course other = (Course) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{id=" + id
                + ", name='" + name
                + "', durationInWeeks=" + durationInWeeks + "}";
    }
}