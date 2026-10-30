
import java.util.Scanner;

public class w10ap1 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        Node head;
        Node tail;
        int size;

        void addFirst(int token) {
            Node newNode = new Node(token);

            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }

            size++;
        }

        void addLast(int token) {
            Node newNode = new Node(token);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        void insertAt(int index, int token) {
            if (index < 0 || index > size) {
                System.out.println("Invalid index");
                return;
            }

            if (index == 0) {
                addFirst(token);
                return;
            }

            if (index == size) {
                addLast(token);
                return;
            }

            Node newNode = new Node(token);
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

        void display() {
            Node current = head;

            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        int operations = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < operations; i++) {
            String command = sc.nextLine().trim();

            if (command.startsWith("addFirst")) {
                int token = Integer.parseInt(
                    command.substring(command.indexOf('(') + 1,
                    command.indexOf(')'))
                );
                list.addFirst(token);

            } else if (command.startsWith("addLast")) {
                int token = Integer.parseInt(
                    command.substring(command.indexOf('(') + 1,
                    command.indexOf(')'))
                );
                list.addLast(token);

            } else if (command.startsWith("insertAt")) {
                String values = command.substring(
                    command.indexOf('(') + 1,
                    command.indexOf(')')
                );

                String[] parts = values.split(",");
                int index = Integer.parseInt(parts[0].trim());
                int token = Integer.parseInt(parts[1].trim());

                list.insertAt(index, token);
            }
        }

        list.display();
        sc.close();
    }
}
