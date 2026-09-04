import java.util.Scanner;
public class w1ap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the original passage: ");
            String originalPassage = scanner.nextLine();
            System.out.print("Enter your typed passage: ");
            String typedText = scanner.nextLine();
            checkTypingAccuracy(originalPassage, typedText);
        } finally {
            scanner.close();
        }
    }
    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Both strings must have the same length.");
            return;
        }
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;
        char originalCharacter = '\0';
        char typedCharacter = '\0';
        for (int index = 0; index < original.length(); index++) {
            if (original.charAt(index) == typed.charAt(index)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = index + 1;
                originalCharacter = original.charAt(index);
                typedCharacter = typed.charAt(index);
            }
        }
        int totalCharacters = original.length();
        double accuracyPercentage = totalCharacters == 0 ? 100.0 : (matchedCharacters * 100.0) / totalCharacters;
        if (firstMismatchPosition == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", matchedCharacters, totalCharacters, accuracyPercentage);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n", matchedCharacters, totalCharacters, accuracyPercentage, firstMismatchPosition, originalCharacter, typedCharacter);
        }
    }
}