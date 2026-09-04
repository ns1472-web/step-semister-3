import java.util.Scanner;
public class w2q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the filename: ");
            String filename = scanner.nextLine();
            String result = validateFileExtension(filename);
            System.out.println(result);
        } finally {
            scanner.close();
        }
    }
    public static String validateFileExtension(String filename) {
        String cleanFilename = filename.trim();
        int dotPosition = cleanFilename.lastIndexOf('.');
        if (dotPosition <= 0 || dotPosition == cleanFilename.length() - 1) {
            return "Rejected — invalid file type";
        }
        String extension = cleanFilename.substring(dotPosition + 1);
        if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx") || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected — invalid file type";
    }
}