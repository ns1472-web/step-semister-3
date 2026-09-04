import java.util.Scanner;
import java.util.Random;
public class w1q1 {
    static String findWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Draw";
        }
        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
    static String getComputerMove() {
        Random random = new Random();
        int choice = random.nextInt(3);
        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        }
        return "Scissors";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wins = 0;
        int losses = 0;
        int draws = 0;
        System.out.print("Enter number of rounds: ");
        int rounds = scanner.nextInt();
        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i);
            System.out.print("Enter Rock, Paper or Scissors: ");
            String playerMove = scanner.next();
            String computerMove = getComputerMove();
            String result = findWinner(playerMove, computerMove);
            System.out.println("Player   : " + playerMove);
            System.out.println("Computer : " + computerMove);
            System.out.println("Result   : " + result);
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        double winPercentage = (wins * 100.0) / rounds;
        System.out.println("\n----- Final Score -----");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage + "%");
        scanner.close();
    }
}