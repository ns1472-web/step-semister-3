import java.util.Scanner;
public class w2ap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a sentence: ");
            String sentence = scanner.nextLine();
            String reversedSentence = reverseEachWord(sentence);
            System.out.println(reversedSentence);
        } finally {
            scanner.close();
        }
    }
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < words.length; index++) {
            StringBuilder reversedWord = new StringBuilder(words[index]);
            reversedWord.reverse();
            result.append(reversedWord);
            if (index < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}