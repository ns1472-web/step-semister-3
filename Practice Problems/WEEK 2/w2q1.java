import java.util.Scanner;
public class w2q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a title: ");
            String title = scanner.nextLine();
            countVowelsAndConsonants(title);
        } finally {
            scanner.close();
        }
    }
    public static void countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (int index = 0; index < text.length(); index++) {
            char currentCharacter = Character.toLowerCase(text.charAt(index));
            if (currentCharacter == 'a' || currentCharacter == 'e' || currentCharacter == 'i' || currentCharacter == 'o' || currentCharacter == 'u') {
                vowelCount++;
            } else if (Character.isLetter(currentCharacter)) {
                consonantCount++;
            }
        }
        System.out.println("Vowels: " + vowelCount + " | Consonants: " + consonantCount);
    }
}