
public class Student {
    private int id;
    private String name;
    private String department;
    private double mark;

    public Student(int id, String name, String department, double mark) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getMark() {
        return mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Mark: " + mark);
        System.out.println("--------------------");
    }
}
