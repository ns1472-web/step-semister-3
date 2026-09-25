class LibraryMember {
    protected int totalFine;
    private int[] fineHistory = new int[10];
    private int fineCount;

    protected void chargeFine(int amount) {
        totalFine += amount;
        fineHistory[fineCount] = amount;
        fineCount++;
    }

    public int[] getFineHistory() {
        int[] history = new int[fineCount];

        for (int i = 0; i < fineCount; i++) {
            history[i] = fineHistory[i];
        }

        return history;
    }

    public int getTotalFine() {
        return totalFine;
    }
}

class StudentMember extends LibraryMember {
    private String memberId;
    private int borrowLimit;
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class w6q3 {
    public static void main(String[] args) {
        StudentMember student = new StudentMember("STU5", 3, "CSE");

        student.chargeFine(100);

        System.out.println(student.getTotalFine());

        int[] history = student.getFineHistory();
        history[0] = 999;

        System.out.println(student.getFineHistory()[0]);
    }
}