import java.util.Scanner;

public class w11q2 {

    static class DNode {
        int data;
        DNode prev, next;

        DNode(int data) {
            this.data = data;
        }
    }

    static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);

        if (head == null) {
            return newNode;
        }

        DNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;

        return head;
    }

    static void display(DNode head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" <-> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        DNode head = null, tail = null;

        for (int i = 0; i < n; i++) {
            DNode newNode = new DNode(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        int value = sc.nextInt();

        head = insertAtTailDoubly(head, value);
        display(head);

        sc.close();
    }
}
