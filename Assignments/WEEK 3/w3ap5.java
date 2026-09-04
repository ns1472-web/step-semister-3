class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;
    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}
public class w3ap5 {
    public static void main(String[] args) {
        createEmployees();
        Employee.printCompanyInfo();
    }
    static void createEmployees() {
        new Employee("Divya", 65000);
        new Employee("Arjun", 30000);
        new Employee("Priya", 55000);
    }
}