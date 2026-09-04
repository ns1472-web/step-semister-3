class FeeAccount {
    String accountName;
    FeeAccount(String accountName) {
        this.accountName = accountName;
    }
    void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}
class HostelFeeAccount extends FeeAccount {
    HostelFeeAccount(String accountName) {
        super(accountName);
    }
    void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}
public class w4q5 {
    static int hostelCount = 0;
    static int dayScholarCount = 0;
    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount("Hostel 1"),
            new HostelFeeAccount("Hostel 2"),
            new FeeAccount("Student 3"),
            new FeeAccount("Student 4")
        };
        processBatch(accounts, 60000);
        printCounts();
    }
    static void processBatch(FeeAccount[] accounts, double amount) {
        for (FeeAccount account : accounts) {
            processPayment(account, amount);
        }
    }
    static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            account.pay(amount);
            hostelCount++;
        } else {
            account.pay(amount);
            dayScholarCount++;
        }
    }
    static void printCounts() {
        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}