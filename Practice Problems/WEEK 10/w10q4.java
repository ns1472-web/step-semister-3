import java.util.*;

public class w10q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<int[]> marksList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\[");
            String name = parts[0].trim();

            String marksText = parts[1].replace("]", "").trim();
            String[] values = marksText.split(",");

            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                marks[i] = Integer.parseInt(values[i].trim());
            }

            names.add(name);
            marksList.add(marks);
        }

        int n = names.size();
        if (n == 0) {
            sc.close();
            return;
        }

        int[][] grid = new int[n][3];
        int[] totals = new int[n];
        int[] subjectTotals = new int[3];

        System.out.print("Totals ");

        for (int i = 0; i < n; i++) {
            grid[i] = marksList.get(i);

            for (int j = 0; j < 3; j++) {
                totals[i] += grid[i][j];
                subjectTotals[j] += grid[i][j];
            }

            System.out.print(names.get(i) + " " + totals[i]);

            if (i < n - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        System.out.print("averages ");

        for (int j = 0; j < 3; j++) {
            double average = (double) subjectTotals[j] / n;
            System.out.printf(Locale.US, "%.2f", average);

            if (j < 2) {
                System.out.print(", ");
            }
        }

        int topper = 0;

        for (int i = 1; i < n; i++) {
            if (totals[i] > totals[topper]) {
                topper = i;
            }
        }

        System.out.println();
        System.out.println("topper " + names.get(topper) + " (" + totals[topper] + ")");

        sc.close();
    }
}