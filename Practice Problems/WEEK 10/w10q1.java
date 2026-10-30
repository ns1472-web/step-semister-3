import java.util.*;

class Account {
    String id;
    String type;
    long balance;

    Account(String id, String type, long balance) {
        this.id = id;
        this.type = type;
        this.balance = balance;
    }

    void withdraw(long amount) {
        if (type.equals("Savings")) {
            if (balance - amount < 1000) {
                System.out.println(id + " rejected: minimum balance 1000");
            } else {
                balance -= amount;
                System.out.println(id + " balance " + balance);
            }
        } else {
            if (balance - amount < -5000) {
                System.out.println(id + " rejected: overdraft limit 5000");
            } else {
                balance -= amount;
                System.out.println(id + " balance " + balance);
            }
        }
    }
}

public class w10q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equals("Savings") || parts[0].equals("Current")) {
                String type = parts[0];
                String id = parts[1];
                long balance = Long.parseLong(parts[2]);

                accounts.put(id, new Account(id, type, balance));
            } else if (parts[0].equals("WITHDRAW")) {
                String id = parts[1];
                long amount = Long.parseLong(parts[2]);

                if (accounts.containsKey(id)) {
                    accounts.get(id).withdraw(amount);
                } else {
                    System.out.println("Account not found");
                }
            }
        }

        sc.close();
    }
}