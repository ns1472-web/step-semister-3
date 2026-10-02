import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

interface Assignment {
    String getTitle();
    int getMaxMarks();
    LocalDate getDueDate();
    double applyPenalty(double marks, long lateDays);
}

class CodingAssignment implements Assignment {
    private String title;
    private int maxMarks;
    private LocalDate dueDate;

    public CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public double applyPenalty(double marks, long lateDays) {
        return marks * Math.pow(0.90, lateDays);
    }
}

class WrittenAssignment implements Assignment {
    private String title;
    private int maxMarks;
    private LocalDate dueDate;

    public WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public double applyPenalty(double marks, long lateDays) {
        return marks * Math.pow(0.80, lateDays);
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Submission {
    private Student student;
    private Assignment assignment;
    private LocalDate submissionDate;
    private String status;
    private double finalMarks;

    public Submission(Student student, Assignment assignment, LocalDate submissionDate) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        status = "Submitted";
    }

    public void grade(double awardedMarks) {
        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade this submission.");
            return;
        }

        long lateDays = 0;

        if (submissionDate.isAfter(assignment.getDueDate())) {
            lateDays = ChronoUnit.DAYS.between(assignment.getDueDate(), submissionDate);
        }

        finalMarks = assignment.applyPenalty(awardedMarks, lateDays);
        status = "Graded";

        System.out.printf("%s graded: %.0f/%d. Status: Graded.%n",
                student.getName(), finalMarks, assignment.getMaxMarks());
    }

    public void resubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" + assignment.getTitle()
                    + "' has already been graded.");
        }
    }
}

class w8q2 {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding = new CodingAssignment(
                "Linked List Lab", 50, LocalDate.of(2026, 3, 10));

        Assignment written = new WrittenAssignment(
                "Design Essay", 50, LocalDate.of(2026, 3, 12));

        Submission s1 = new Submission(
                asha, coding, LocalDate.of(2026, 3, 10));

        Submission s2 = new Submission(
                ravi, written, LocalDate.of(2026, 3, 14));

        System.out.println("Asha's submission for 'Linked List Lab' received (on time). Status: Submitted.");
        System.out.println("Ravi's submission for 'Design Essay' received (2 days late). Status: Submitted.");

        s1.grade(45);
        s2.grade(40);

        s1.resubmit();
    }
}