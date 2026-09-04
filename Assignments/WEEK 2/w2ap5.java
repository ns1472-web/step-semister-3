import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class w2ap5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter feedback text: ");
            String feedback = scanner.nextLine();
            printFilteredWordFrequency(feedback);
        } finally {
            scanner.close();
        }
    }
    public static void printFilteredWordFrequency(String feedback) {
        String cleanedFeedback = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedFeedback.trim().split("\\s+");
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word, stopWords)) {
                continue;
            }
            int currentCount = wordFrequency.getOrDefault(word, 0);
            wordFrequency.put(word, currentCount + 1);
        }
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordFrequency.entrySet());
        sortedWords.sort((firstEntry, secondEntry) -> secondEntry.getValue().compareTo(firstEntry.getValue()));
        for (Map.Entry<String, Integer> entry : sortedWords) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }
}