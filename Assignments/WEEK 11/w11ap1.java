
import java.util.Scanner;

public class w11ap1 {

    static int[] bubbleStats(int[] scores) {
        int passes = 0, swaps = 0;
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }

        return new int[]{passes, swaps};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++)
            scores[i] = sc.nextInt();

        int[] result = bubbleStats(scores);

        for (int x : scores)
            System.out.print(x + " ");

        System.out.println("\nPasses = " + result[0]);
        System.out.println("Swaps = " + result[1]);

        sc.close();
    }
}
