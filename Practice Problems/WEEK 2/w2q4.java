import java.util.Scanner;
public class w2q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            String result = maskPhoneNumber(phoneNumber);
            System.out.println(result);
        } finally {
            scanner.close();
        }
    }
    public static String maskPhoneNumber(String phone) {
        String cleanPhone = phone.trim();
        if (cleanPhone.length() != 10) {
            return "Invalid phone number";
        }
        for (int index = 0; index < cleanPhone.length(); index++) {
            if (!Character.isDigit(cleanPhone.charAt(index))) {
                return "Invalid phone number";
            }
        }
        String lastFourDigits = cleanPhone.substring(cleanPhone.length() - 4);
        StringBuilder maskedNumber = new StringBuilder("XXXXXX");
        maskedNumber.insert(maskedNumber.length(), "-" + lastFourDigits);
        return maskedNumber.toString();
    }
}