import java.util.Scanner;
public class w2ap4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the ISBN-style code: ");
            String rawCode = scanner.nextLine();
            String normalizedCode = normalizeCode(rawCode);
            String result = validateAndFormat(normalizedCode);
            System.out.println(result);
        } finally {
            scanner.close();
        }
    }
    public static String normalizeCode(String raw) {
        String cleanCode = raw.trim();
        if (cleanCode.length() < 3) {
            return cleanCode.toUpperCase();
        }
        String publisherCode = cleanCode.substring(0, 3).toUpperCase();
        String remainingCode = cleanCode.substring(3);
        return publisherCode + remainingCode;
    }
    public static String validateAndFormat(String code) {
        final int requiredLength = 13;
        if (code.length() != requiredLength) {
            return "Invalid: wrong length";
        }
        String publisherCode = code.substring(0, 3);
        for (int index = 0; index < publisherCode.length(); index++) {
            if (!Character.isLetter(publisherCode.charAt(index))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        String body = code.substring(3);
        for (int index = 0; index < body.length(); index++) {
            if (!Character.isDigit(body.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7);
        StringBuilder formattedCode = new StringBuilder();
        formattedCode.append("[");
        formattedCode.append(publisherCode);
        formattedCode.append("] YEAR: ");
        formattedCode.append(year);
        formattedCode.append(" | CATALOG: ");
        formattedCode.append(catalogNumber);
        return formattedCode.toString();
    }
}