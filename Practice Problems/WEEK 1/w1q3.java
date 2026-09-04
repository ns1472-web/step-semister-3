import java.util.Scanner;
public class w1q3 {
    static double calculateBmi(double height, double weight) {
        return weight / (height * height);
    }
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    static void printReport(double[] heights, double[] weights) {
        System.out.println("\nPerson\tHeight\tWeight\tBMI\tStatus");
        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBmi(heights[i], weights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n", i + 1, heights[i], weights[i], bmi, status);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int numberOfPeople = scanner.nextInt();
        double[] heights = new double[numberOfPeople];
        double[] weights = new double[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Enter height in meters: ");
            heights[i] = scanner.nextDouble();
            System.out.print("Enter weight in kg: ");
            weights[i] = scanner.nextDouble();
        }
        printReport(heights, weights);
        scanner.close();
    }
}
