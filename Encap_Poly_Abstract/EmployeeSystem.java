// Problem 1 – Employee Management System
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    Employee(int id, String name, double baseSalary) {
        this.employeeId = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double s) { this.baseSalary = s; }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary
                           + ", Total Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    FullTimeEmployee(int id, String name, double fixedSalary) {
        super(id, name, fixedSalary);
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Fixed salary
    }
    @Override
    public void assignDepartment(String dept) { this.department = dept; }
    @Override
    public String getDepartmentDetails() { return department; }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;
    PartTimeEmployee(int id, String name, int hours, double rate) {
        super(id, name, 0);
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
    @Override
    public void assignDepartment(String dept) { this.department = dept; }
    @Override
    public String getDepartmentDetails() { return department; }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee[] staff = {
            new FullTimeEmployee(1, "Alice", 80000),
            new PartTimeEmployee(2, "Bob", 120, 40)
        };
        ((Department) staff[0]).assignDepartment("HR");
        ((Department) staff[1]).assignDepartment("Support");
        for (Employee e : staff) {
            e.displayDetails();
            System.out.println("Department: " + ((Department) e).getDepartmentDetails());
            System.out.println("---");
        }
    }
}