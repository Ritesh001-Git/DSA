import java.util.Arrays;

public class CountTheNumbersOffairPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(countFairPairs(nums, 1, 3)); // Output: 4
    }
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower - 1);
    }
    public static long count(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        long c = 0;
        while (i < j) {
            if (nums[i] + nums[j] <= target) {
                c += j - i;
                i++;
            } else {
                j--;
            }
        }
        return c;
    }
}
