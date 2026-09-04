import java.util.Scanner;
public class w1ap3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the traffic signal log: ");
            String signalLog = scanner.nextLine().trim().toUpperCase();
            if (signalLog.isEmpty()) {
                System.out.println("Traffic signal log cannot be empty.");
                return;
            }
            findLongestStreak(signalLog);
        } finally {
            scanner.close();
        }
    }
    public static void findLongestStreak(String signalLog) {
        int currentStreak = 1;
        int longestStreak = 1;
        char currentColor = signalLog.charAt(0);
        char longestColor = currentColor;
        for (int index = 1; index < signalLog.length(); index++) {
            char signalColor = signalLog.charAt(index);
            if (signalColor == currentColor) {
                currentStreak++;
            } else {
                currentColor = signalColor;
                currentStreak = 1;
            }
            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = currentColor;
            }
        }
        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestStreak + " times");
    }
}