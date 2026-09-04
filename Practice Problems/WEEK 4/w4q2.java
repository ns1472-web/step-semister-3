class Employee {
    String empId;
    double salary;
    Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }
    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }
    void printSalary() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }
}
public class w4q2 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };
        applyRaise(employees, 5000);
    }
    static void applyRaise(Employee[] employees, double raise) {
        for (Employee employee : employees) {
            employee.raiseSalary(raise);
            employee.printSalary();
        }
    }
}