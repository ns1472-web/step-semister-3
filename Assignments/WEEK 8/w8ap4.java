interface MembershipPlan {
    double calculateFee();
    String getPlanName();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 1000;
    }

    public String getPlanName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }

    public String getPlanName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }

    public String getPlanName() {
        return "Annual";
    }
}

class Member {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Membership {
    private Member member;
    private MembershipPlan plan;
    private String status;

    public Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        status = "Active";
    }

    public void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member.getName() + " checked in successfully.");
        } else {
            System.out.println("Cannot check in. Membership is " + status + ".");
        }
    }

    public void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(member.getName() + "'s membership is now Frozen.");
        } else {
            System.out.println("Cannot freeze an " + status + " membership.");
        }
    }

    public void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member.getName() + "'s membership is now Active.");
        } else {
            System.out.println("Cannot unfreeze an " + status + " membership.");
        }
    }

    public void expire() {
        status = "Expired";
        System.out.println(member.getName() + "'s membership has Expired.");
    }

    public double getFee() {
        return plan.calculateFee();
    }

    public String getPlanName() {
        return plan.getPlanName();
    }
}

class w8ap4 {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership ashaMembership =
                new Membership(asha, new QuarterlyPlan());

        Membership raviMembership =
                new Membership(ravi, new MonthlyPlan());

        System.out.printf("Asha's Quarterly membership fee: ₹%.2f%n",
                ashaMembership.getFee());

        System.out.printf("Ravi's Monthly membership fee: ₹%.2f%n",
                raviMembership.getFee());

        ashaMembership.checkIn();
        ashaMembership.freeze();
        ashaMembership.checkIn();
        ashaMembership.unfreeze();

        raviMembership.expire();
        raviMembership.freeze();
        raviMembership.checkIn();
    }
}