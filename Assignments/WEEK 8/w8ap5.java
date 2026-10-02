interface NotificationChannel {
    void send(String studentName, String title);
}

class EmailChannel implements NotificationChannel {
    public void send(String studentName, String title) {
        System.out.println("Email sent to " + studentName + " for notice: " + title);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String studentName, String title) {
        System.out.println("SMS sent to " + studentName + " for notice: " + title);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String studentName, String title) {
        System.out.println("App notification sent to " + studentName + " for notice: " + title);
    }
}

class Student {
    private String name;
    private String department;
    private java.util.ArrayList<NotificationChannel> channels;

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
        channels = new java.util.ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    public void receiveNotice(String title) {
        for (NotificationChannel channel : channels) {
            channel.send(name, title);
        }
    }
}

class Notice {
    private String title;
    private java.util.ArrayList<String> departments;

    public Notice(String title, java.util.ArrayList<String> departments) {
        this.title = title;
        this.departments = departments;
    }

    public String getTitle() {
        return title;
    }

    public boolean targetsDepartment(String department) {
        return departments.contains(department);
    }
}

class NoticeBoard {
    private java.util.ArrayList<Student> students;

    public NoticeBoard() {
        students = new java.util.ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void postNotice(Notice notice) {
        if (notice.getTitle() == null || notice.getTitle().trim().isEmpty()) {
            System.out.println("Cannot post notice without a title.");
            return;
        }

        boolean hasTarget = false;

        for (Student student : students) {
            if (notice.targetsDepartment(student.getDepartment())) {
                hasTarget = true;
                break;
            }
        }

        if (!hasTarget) {
            System.out.println("Cannot post notice without a target department.");
            return;
        }

        System.out.println("Notice '" + notice.getTitle() + "' posted.");

        for (Student student : students) {
            if (notice.targetsDepartment(student.getDepartment())) {
                student.receiveNotice(notice.getTitle());
            }
        }
    }
}

class w8ap5 {
    public static void main(String[] args) {
        Student asha = new Student("Asha", "CSE");
        Student ravi = new Student("Ravi", "ECE");

        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());
        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();
        board.addStudent(asha);
        board.addStudent(ravi);

        java.util.ArrayList<String> cse =
                new java.util.ArrayList<>();
        cse.add("CSE");

        Notice notice1 =
                new Notice("Lab Exam Tomorrow", cse);

        board.postNotice(notice1);

        java.util.ArrayList<String> cseEce =
                new java.util.ArrayList<>();
        cseEce.add("CSE");
        cseEce.add("ECE");

        Notice notice2 =
                new Notice("Campus Placement Drive", cseEce);

        board.postNotice(notice2);

        java.util.ArrayList<String> noTarget =
                new java.util.ArrayList<>();

        Notice invalidNotice =
                new Notice("General Notice", noTarget);

        board.postNotice(invalidNotice);
    }
}