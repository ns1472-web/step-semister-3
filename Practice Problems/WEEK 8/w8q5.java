interface NotificationChannel {
    void send(Student student, Notice notice);
}

class EmailChannel implements NotificationChannel {
    public void send(Student student, Notice notice) {
        System.out.println("[Email → " + student.getName() + "] "
                + notice.getTitle());
    }
}

class SmsChannel implements NotificationChannel {
    public void send(Student student, Notice notice) {
        System.out.println("[SMS → " + student.getName() + "] "
                + notice.getTitle());
    }
}

class AppChannel implements NotificationChannel {
    public void send(Student student, Notice notice) {
        System.out.println("[App → " + student.getName() + "] "
                + notice.getTitle());
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

    public void receiveNotice(Notice notice) {
        for (NotificationChannel channel : channels) {
            channel.send(this, notice);
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

    public java.util.ArrayList<String> getDepartments() {
        return departments;
    }

    public boolean isValid() {
        return title != null && !title.trim().isEmpty()
                && departments != null && !departments.isEmpty();
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
        if (!notice.isValid()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + notice.getTitle() + "' posted.");

        for (Student student : students) {
            if (notice.getDepartments().contains(student.getDepartment())) {
                student.receiveNotice(notice);
            }
        }
    }
}

class w8q5 {
    public static void main(String[] args) {
        Student asha = new Student("Asha", "CSE");
        Student ravi = new Student("Ravi", "ECE");

        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());
        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();
        board.addStudent(asha);
        board.addStudent(ravi);

        java.util.ArrayList<String> cse = new java.util.ArrayList<>();
        cse.add("CSE");

        Notice notice1 = new Notice("Lab Closed Tomorrow", cse);
        board.postNotice(notice1);

        java.util.ArrayList<String> departments = new java.util.ArrayList<>();
        departments.add("CSE");
        departments.add("ECE");

        Notice notice2 = new Notice("Fee Deadline Extended", departments);
        board.postNotice(notice2);

        java.util.ArrayList<String> empty = new java.util.ArrayList<>();
        Notice notice3 = new Notice("Sports Day", empty);
        board.postNotice(notice3);
    }
}