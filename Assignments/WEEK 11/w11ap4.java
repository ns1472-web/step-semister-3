
import java.util.Scanner;

public class w11ap4 {

    static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    static int kthHighest(int[] marks, int k) {
        int target = marks.length - k;
        int low = 0, high = marks.length - 1;

        while (low <= high) {
            int p = partition(marks, low, high);

            if (p == target)
                return marks[p];
            else if (p < target)
                low = p + 1;
            else
                high = p - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] marks = new int[n];

        for (int i = 0; i < n; i++)
            marks[i] = sc.nextInt();

        int k = sc.nextInt();

        System.out.println(kthHighest(marks, k));

        sc.close();
    }
}
