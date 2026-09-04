class Payment {
    void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }
}
class CardPayment extends Payment {
    void payWithProcessingFee(double amount) {
        double totalAmount = amount + (amount * 2 / 100);
        System.out.println("Charged (card, incl. fee): Rs " + totalAmount);
    }
}
public class w4ap5 {
    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };
        double[] amounts = {100, 50, 200, 75, 120};
        double totalCollected = processPayments(payments, amounts);
        System.out.println("Total Collected: Rs " + totalCollected);
    }
    static double processPayments(Payment[] payments, double[] amounts) {
        double totalCollected = 0;
        for (int i = 0; i < payments.length; i++) {
            totalCollected += processTransaction(payments[i], amounts[i]);
        }
        return totalCollected;
    }
    static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            double chargedAmount = amount + (amount * 2 / 100);
            cardPayment.payWithProcessingFee(amount);
            return chargedAmount;
        } else {
            payment.pay(amount);
            return amount;
        }
    }
}