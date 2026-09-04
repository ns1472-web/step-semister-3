import java.util.Scanner;
public class w2q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter transaction reference: ");
            String rawReference = scanner.nextLine();
            String normalizedReference = normalizeReference(rawReference);
            String result = validateAndFormat(normalizedReference);
            System.out.println(result);
        } finally {
            scanner.close();
        }
    }
    public static String normalizeReference(String raw) {
        String cleanReference = raw.trim();
        if (cleanReference.length() < 3) {
            return cleanReference.toUpperCase();
        }
        String bankCode = cleanReference.substring(0, 3).toUpperCase();
        String remainingPart = cleanReference.substring(3);
        return bankCode + remainingPart;
    }
    public static String validateAndFormat(String reference) {
        final int requiredLength = 14;
        if (reference.length() != requiredLength) {
            return "Invalid: wrong length";
        }
        String bankCode = reference.substring(0, 3);
        for (int index = 0; index < bankCode.length(); index++) {
            if (!Character.isLetter(bankCode.charAt(index))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        String body = reference.substring(3);
        for (int index = 0; index < body.length(); index++) {
            if (!Character.isDigit(body.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }
        String datePart = reference.substring(3, 9);
        String sequencePart = reference.substring(9);
        String formattedDate = datePart.substring(0, 2) + "/" + datePart.substring(2, 4) + "/" + datePart.substring(4, 6);
        StringBuilder formattedReference = new StringBuilder();
        formattedReference.append("[");
        formattedReference.append(bankCode);
        formattedReference.append("] DATE: ");
        formattedReference.append(formattedDate);
        formattedReference.append(" | SEQ: ");
        formattedReference.append(sequencePart);
        return formattedReference.toString();
    }
}