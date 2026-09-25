class GymMember {
    private int[] lateFeeHistory = new int[10];
    private int feeCount;
    private int totalLateFees;

    protected void chargeLateFee(int amount) {
        totalLateFees += amount;
        lateFeeHistory[feeCount] = amount;
        feeCount++;
    }

    public int[] getLateFeeHistory() {
        int[] history = new int[feeCount];

        for (int i = 0; i < feeCount; i++) {
            history[i] = lateFeeHistory[i];
        }

        return history;
    }

    public int getTotalLateFees() {
        return totalLateFees;
    }
}

class PremiumMember extends GymMember {
    private String memberId;
    private int monthlyFee;
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class w6ap3 {
    public static void main(String[] args) {
        PremiumMember member =
                new PremiumMember("MEM5", 2000, "Coach Riya");

        member.chargeLateFee(200);

        System.out.println(member.getTotalLateFees());

        int[] history = member.getLateFeeHistory();
        history[0] = 999;

        int[] updatedHistory = member.getLateFeeHistory();

        System.out.println(updatedHistory[0]);
    }
}