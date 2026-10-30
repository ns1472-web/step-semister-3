
import java.util.Scanner;

public class w10ap5 {

    static class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        Node tail;

        void addLast(String name) {
            Node newNode = new Node(name);

            if (tail == null) {
                tail = newNode;
                tail.next = newNode;
            } else {
                newNode.next = tail.next;
                tail.next = newNode;
                tail = newNode;
            }
        }

        void printTurns(int turns) {
            if (tail == null) {
                return;
            }

            Node current = tail.next;

            for (int i = 0; i < turns; i++) {
                System.out.print(current.name);

                if (i < turns - 1) {
                    System.out.print(" ");
                }

                current = current.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CircularLinkedList players = new CircularLinkedList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            players.addLast(sc.next());
        }

        int turns = sc.nextInt();

        players.printTurns(turns);

        sc.close();
    }
}
