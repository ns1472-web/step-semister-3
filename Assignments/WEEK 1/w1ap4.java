import java.util.Scanner;
public class w1ap4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of items: ");
            int itemCount = scanner.nextInt();
            if (itemCount <= 0) {
                System.out.println("Number of items must be greater than zero.");
                return;
            }
            int[] sectionA = new int[itemCount];
            int[] sectionB = new int[itemCount];
            System.out.println("Enter quantities for Section A:");
            for (int index = 0; index < itemCount; index++) {
                System.out.print("Item " + (index + 1) + ": ");
                sectionA[index] = scanner.nextInt();
            }
            System.out.println("Enter quantities for Section B:");
            for (int index = 0; index < itemCount; index++) {
                System.out.print("Item " + (index + 1) + ": ");
                sectionB[index] = scanner.nextInt();
            }
            analyzeInventory(sectionA, sectionB);
        } catch (java.util.InputMismatchException exception) {
            System.out.println("Please enter valid integer quantities.");
        } finally {
            scanner.close();
        }
    }
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sectionATotal = calculateTotal(sectionA);
        int sectionBTotal = calculateTotal(sectionB);
        String inventoryStatus = sectionATotal == sectionBTotal ? "Balanced" : "Not Balanced";
        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;
        for (int index = 0; index < sectionA.length; index++) {
            if (sectionA[index] > highestQuantity) {
                highestQuantity = sectionA[index];
                highestSection = "Section A";
                highestIndex = index;
            }
            if (sectionB[index] > highestQuantity) {
                highestQuantity = sectionB[index];
                highestSection = "Section B";
                highestIndex = index;
            }
        }
        System.out.println("Section A Total: " + sectionATotal + " | Section B Total: " + sectionBTotal + " | Status: " + inventoryStatus);
        System.out.println("Highest Quantity: " + highestQuantity + " (" + highestSection + ", Item " + (highestIndex + 1) + ")");
    }
    public static int calculateTotal(int[] quantities) {
        int totalQuantity = 0;
        for (int quantity : quantities) {
            totalQuantity += quantity;
        }
        return totalQuantity;
    }
}