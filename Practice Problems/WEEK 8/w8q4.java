interface MembershipPlan {
    int getMonths();
    double calculateFee();
    String getPlanName();
}

class MonthlyPlan implements MembershipPlan {
    public int getMonths() {
        return 1;
    }

    public double calculateFee() {
        return 1000;
    }

    public String getPlanName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {
    public int getMonths() {
        return 3;
    }

    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }

    public String getPlanName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {
    public int getMonths() {
        return 12;
    }

    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }

    public String getPlanName() {
        return "Annual";
    }
}

class Member {
    private String name;
    private Membership membership;

    public Member(String name) {
        this.name = name;
    }

    public void buyMembership(MembershipPlan plan) {
        membership = new Membership(plan);

        System.out.printf("%s membership created for %s. Fee: ₹%.2f. Status: Active.%n",
                plan.getPlanName(), name, membership.getFee());
    }

    public void checkIn() {
        if (membership != null && membership.checkIn()) {
            System.out.println(name + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + name
                    + "'s membership is not Active.");
        }
    }

    public void freeze() {
        if (membership != null && membership.freeze()) {
            System.out.println(name + "'s membership frozen. Status: Frozen.");
        } else {
            System.out.println("Cannot freeze an " + membership.getStatus()
                    + " membership.");
        }
    }

    public void unfreeze() {
        if (membership != null && membership.unfreeze()) {
            System.out.println(name + "'s membership unfrozen. Status: Active.");
        }
    }

    public void expire() {
        if (membership != null) {
            membership.expire();
            System.out.println(name + "'s membership expired. Status: Expired.");
        }
    }
}

class Membership {
    private MembershipPlan plan;
    private String status;
    private double fee;

    public Membership(MembershipPlan plan) {
        this.plan = plan;
        fee = plan.calculateFee();
        status = "Active";
    }

    public double getFee() {
        return fee;
    }

    public String getStatus() {
        return status;
    }

    public boolean checkIn() {
        return status.equals("Active");
    }

    public boolean freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            return true;
        }

        return false;
    }

    public boolean unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            return true;
        }

        return false;
    }

    public void expire() {
        status = "Expired";
    }
}

class w8q4 {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        asha.buyMembership(new QuarterlyPlan());
        ravi.buyMembership(new MonthlyPlan());

        asha.checkIn();
        asha.freeze();
        asha.checkIn();

        ravi.expire();
        ravi.freeze();
    }
}