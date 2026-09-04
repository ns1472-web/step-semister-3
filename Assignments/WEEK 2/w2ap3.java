import java.util.Scanner;
public class w2ap3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter inventory record: ");
            String csvLine = scanner.nextLine();
            parseInventoryRecord(csvLine);
        } finally {
            scanner.close();
        }
    }
    public static void parseInventoryRecord(String csvLine) {
        String[] productDetails = csvLine.split(",");
        if (productDetails.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        String productName = productDetails[0].trim();
        String sku = productDetails[1].trim();
        String quantity = productDetails[2].trim();
        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }
}