import java.util.*;

public class w9q3 {
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {8, 3, 5, 2, 7};
        int target = 10;

        System.out.println(hasPairWithSum(nums, target));
    }
}