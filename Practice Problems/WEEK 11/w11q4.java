import java.util.Scanner;

public class w11q4 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node deleteNthNode(Node head, int n) {
        if (n == 1) {
            return head.next;
        }

        Node current = head;

        for (int i = 1; i < n - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        return head;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int position = sc.nextInt();

        head = deleteNthNode(head, position);
        display(head);

        sc.close();
    }
}
