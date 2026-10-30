import java.util.*;

class Student {
    String rollNumber;
    String name;

    Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return rollNumber.equals(s.rollNumber);
    }

    public int hashCode() {
        return rollNumber.hashCode();
    }
}

public class w10q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> members = new HashSet<>();
        List<Student> checks = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");

            if (parts[0].equals("ADD")) {
                Student s = new Student(parts[1], parts[2]);

                if (members.add(s)) {
                    System.out.println("Added");
                } else {
                    System.out.println("duplicate rejected");
                }
            } else if (parts[0].equals("CONTAINS")) {
                checks.add(new Student(parts[1], parts[2]));
            }
        }

        System.out.println("member count " + members.size());

        for (Student s : checks) {
            System.out.println("contains: " + members.contains(s));
        }

        sc.close();
    }
}