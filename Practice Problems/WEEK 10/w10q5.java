import java.util.*;

abstract class Staff {
    String name;
    String type;

    Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract long calculatePay();

    String getPayslip() {
        return "Payslip[name=" + name + ", type=" + type + ", pay=" + calculatePay() + "]";
    }
}

class FullTime extends Staff {
    long salary;

    FullTime(String name, long salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    long calculatePay() {
        return salary;
    }
}

class PartTime extends Staff {
    long hours;
    long rate;

    PartTime(String name, long hours, long rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    long calculatePay() {
        return hours * rate;
    }
}

class Intern extends Staff {
    long stipend;

    Intern(String name, long stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    long calculatePay() {
        return stipend;
    }
}

public class w10q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");

            switch (parts[0]) {
                case "FullTime":
                    staffList.add(new FullTime(
                        parts[1], Long.parseLong(parts[2])
                    ));
                    break;

                case "PartTime":
                    staffList.add(new PartTime(
                        parts[1],
                        Long.parseLong(parts[2]),
                        Long.parseLong(parts[3])
                    ));
                    break;

                case "Intern":
                    staffList.add(new Intern(
                        parts[1], Long.parseLong(parts[2])
                    ));
                    break;
            }
        }

        long total = 0;
        Staff topper = null;

        for (Staff s : staffList) {
            System.out.println(s.getPayslip());
            total += s.calculatePay();

            if (topper == null || s.calculatePay() > topper.calculatePay()) {
                topper = s;
            }
        }

        System.out.println("Total " + total);

        if (topper != null) {
            System.out.println("top earner " + topper.name);
        }

        sc.close();
    }
}