import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + department + " " + salary;
    }
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;
        return this.id == other.id;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

public class EmployeeDirectory {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Arun", "IT", 45000);
        Employee e2 = new Employee(101, "Arun", "IT", 45000);

        System.out.println("\nEquals and HashCode Test:");
        System.out.println("Are employees equal? " + e1.equals(e2));

        Map<Employee, String> testMap = new HashMap<>();
        testMap.put(e1, "Employee One");

        System.out.println("Lookup using equal object: " + testMap.get(e2));

        Map<Integer, Employee> employees = new HashMap<>();

        employees.put(101, new Employee(101, "Arun", "IT", 45000));
        employees.put(102, new Employee(102, "Priya", "HR", 50000));
        employees.put(103, new Employee(103, "Kumar", "IT", 60000));
        employees.put(104, new Employee(104, "Divya", "Sales", 40000));
        employees.put(105, new Employee(105, "Ravi", "HR", 55000));

        Employee employee = employees.get(103);

        if (employee != null) {
            System.out.println("Employee Found:");
            System.out.println(employee);
        } else {
            System.out.println("Employee Not Found");
        }
        Map<String, Integer> departmentCount = new HashMap<>();

        for (Employee e : employees.values()) {
            departmentCount.merge(e.department, 1, Integer::sum);
        }

        System.out.println("\nDepartment Frequency:");

        for (Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        Map<String, java.util.List<Employee>> departmentReport = new TreeMap<>();

        for (Employee e : employees.values()) {
            departmentReport
                .computeIfAbsent(e.department, k -> new java.util.ArrayList<>())
                .add(e);
        }

        System.out.println("\nDepartment Report:");

        for (Map.Entry<String, java.util.List<Employee>> entry : departmentReport.entrySet()) {
            System.out.println(entry.getKey() + ":");

            for (Employee e : entry.getValue()) {
                System.out.println("  " + e);
            }
        }
        List<Employee> sortedEmployees = new ArrayList<>(employees.values());

        Collections.sort(sortedEmployees);

        System.out.println("\nEmployees Sorted by ID:");

        for (Employee e : sortedEmployees) {
            System.out.println(e);
        }
        List<Employee> customSorted = new ArrayList<>(employees.values());

        customSorted.sort(
            Comparator.comparingDouble((Employee e) -> e.salary)
                .reversed()
                .thenComparing(e -> e.name)
        );

        System.out.println("\nEmployees Sorted by Salary and Name:");

        for (Employee e : customSorted) {
            System.out.println(e);
        }
        List<Employee> salarySorted = new ArrayList<>(employees.values());

        salarySorted.sort(
            Comparator.comparingDouble((Employee e) -> e.salary).reversed()
        );

        System.out.println("\nEmployees Sorted by Salary:");

        for (Employee e : salarySorted) {
            System.out.println(e);
        }

        System.out.println("\nTop 5 Highest-Paid Employees:");
        for (int i = 0; i < Math.min(5, salarySorted.size()); i++) {
            System.out.println(salarySorted.get(i));
        }
    }
}