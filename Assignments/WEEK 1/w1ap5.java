import java.util.Scanner;
public class w1ap5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the movie review: ");
            String review = scanner.nextLine();
            classifyWordLengths(review);
        } finally {
            scanner.close();
        }
    }
    public static void classifyWordLengths(String review) {
        if (review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }
        String[] words = review.trim().split("\\s+");
        int shortWordCount = 0;
        int mediumWordCount = 0;
        int longWordCount = 0;
        for (String word : words) {
            int wordLength = word.length();
            if (wordLength >= 1 && wordLength <= 4) {
                shortWordCount++;
            } else if (wordLength <= 8) {
                mediumWordCount++;
            } else {
                longWordCount++;
            }
        }
        System.out.println("Short: " + shortWordCount + " | Medium: " + mediumWordCount + " | Long: " + longWordCount);
    }
}