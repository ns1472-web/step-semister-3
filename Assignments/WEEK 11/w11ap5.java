
import java.util.Scanner;

public class w11ap5 {

    static class Entry {
        String name;
        int marks;

        Entry(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    static Entry[] leaderboard(Entry[] entries) {
        int[] count = new int[101];

        for (Entry e : entries)
            count[100 - e.marks]++;

        for (int i = 1; i < 101; i++)
            count[i] += count[i - 1];

        Entry[] result = new Entry[entries.length];

        for (int i = entries.length - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            result[--count[key]] = entries[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Entry[] entries = new Entry[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int marks = sc.nextInt();
            entries[i] = new Entry(name, marks);
        }

        Entry[] result = leaderboard(entries);

        for (Entry e : result)
            System.out.println(e.name + " " + e.marks);

        sc.close();
    }
}
