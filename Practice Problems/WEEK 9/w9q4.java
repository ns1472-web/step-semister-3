import java.util.*;

public class w9q4 {
    public static boolean findPair(int[] nums, int target) {
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
        int[] nums = {4, 11, 6, 9, 2};
        int target = 15;

        System.out.println(findPair(nums, target));
    }
}