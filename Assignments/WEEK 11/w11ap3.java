
import java.util.Scanner;

public class w11ap3 {

    static long mergeSort(int[] roll, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            count += mergeSort(roll, left, mid);
            count += mergeSort(roll, mid + 1, right);
            count += merge(roll, left, mid, right);
        }

        return count;
    }

    static long merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        long count = 0;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid)
            temp[k++] = a[i++];

        while (j <= right)
            temp[k++] = a[j++];

        for (i = 0; i < temp.length; i++)
            a[left + i] = temp[i];

        return count;
    }

    static long countInversions(int[] roll) {
        return mergeSort(roll, 0, roll.length - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] roll = new int[n];

        for (int i = 0; i < n; i++)
            roll[i] = sc.nextInt();

        System.out.println(countInversions(roll));

        sc.close();
    }
}
