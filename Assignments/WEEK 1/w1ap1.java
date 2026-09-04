import java.util.Scanner;
public class w1ap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of students: ");
            int studentCount = scanner.nextInt();
            if (studentCount <= 0) {
                System.out.println("Number of students must be greater than zero.");
                return;
            }
            int[] seatNumbers = new int[studentCount];
            for (int index = 0; index < studentCount; index++) {
                System.out.print("Enter seat number for student " + (index + 1) + ": ");
                seatNumbers[index] = scanner.nextInt();
            }
            checkDuplicateSeats(seatNumbers);
        } catch (java.util.InputMismatchException exception) {
            System.out.println("Please enter valid integer seat numbers.");
        } finally {
            scanner.close();
        }
    }
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        for (int firstIndex = 0; firstIndex < seatNumbers.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < seatNumbers.length; secondIndex++) {
                if (seatNumbers[firstIndex] == seatNumbers[secondIndex]) {
                    boolean alreadyPrinted = false;
                    for (int previousIndex = 0; previousIndex < firstIndex; previousIndex++) {
                        if (seatNumbers[previousIndex] == seatNumbers[firstIndex]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }
                    if (!alreadyPrinted) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[firstIndex]);
                        duplicateFound = true;
                    }
                }
            }
        }
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}