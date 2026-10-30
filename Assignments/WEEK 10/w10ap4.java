
import java.util.Scanner;

public class w10ap4 {

    static class Node {
        String name;
        Node prev;
        Node next;

        Node(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    static class DoublyLinkedList {
        Node head;
        Node tail;

        void addLast(String name) {
            Node newNode = new Node(name);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        void remove(String name) {
            Node current = head;

            while (current != null && !current.name.equals(name)) {
                current = current.next;
            }

            if (current == null) {
                return;
            }

            if (current == head) {
                head = current.next;
            } else {
                current.prev.next = current.next;
            }

            if (current == tail) {
                tail = current.prev;
            } else {
                current.next.prev = current.prev;
            }
        }

        void printForward() {
            Node current = head;

            System.out.print("Forward: ");

            while (current != null) {
                System.out.print(current.name);

                if (current.next != null) {
                    System.out.print(" <-> ");
                }

                current = current.next;
            }

            System.out.println();
        }

        void printBackward() {
            Node current = tail;

            System.out.print("Backward: ");

            while (current != null) {
                System.out.print(current.name);

                if (current.prev != null) {
                    System.out.print(" <-> ");
                }

                current = current.prev;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DoublyLinkedList train = new DoublyLinkedList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            train.addLast(sc.next());
        }

        String nameToRemove = sc.next();

        train.remove(nameToRemove);

        train.printForward();
        train.printBackward();

        sc.close();
    }
}
