import java.util.Scanner;
public class w2q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter student record: ");
            String csvLine = scanner.nextLine();
            parseStudentRecord(csvLine);
        } finally {
            scanner.close();
        }
    }
    public static void parseStudentRecord(String csvLine) {
        String[] studentDetails = csvLine.split(",");
        if (studentDetails.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        String studentName = studentDetails[0].trim();
        String rollNumber = studentDetails[1].trim();
        String department = studentDetails[2].trim();
        if (studentName.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: " + studentName + " | Roll No: " + rollNumber + " | Dept: " + department);
    }
}