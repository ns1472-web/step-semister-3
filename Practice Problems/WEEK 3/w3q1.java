class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;
    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }
    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}
public class w3q1 {
    public static void main(String[] args) {
        PlacementRecord firstStudent = new PlacementRecord("Ravi", "TCS", 4.5);
        PlacementRecord secondStudent = new PlacementRecord("Anitha", "Zoho", 6.2);
        PlacementRecord thirdStudent = new PlacementRecord("Karthik", "Infosys", 4.0);
        PlacementRecord[] placementRecords = {firstStudent, secondStudent, thirdStudent};
        for (PlacementRecord record : placementRecords) {
            record.printRecord();
        }
    }
}