import java.util.Scanner;
public class w2ap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();
            checkPinLength(pin);
        } finally {
            scanner.close();
        }
    }
    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
}