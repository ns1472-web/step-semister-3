public class w9q5 {
    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = height * width;

            if (area > max) {
                max = area;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(heights));
    }
}