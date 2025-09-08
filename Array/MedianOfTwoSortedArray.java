import java.util.ArrayList;
import java.util.Collections;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of the two sorted arrays: " + median); // Output: 2.0
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> mergedList = new ArrayList<>();

        // Add elements from both arrays to the list
        for (int num : nums1) {
            mergedList.add(num);
        }
        for (int num : nums2) {
            mergedList.add(num);
        }

        // Sort the combined list
        Collections.sort(mergedList);
        int n = mergedList.size();

        // Find the median
        if (n % 2 == 0) {
            return (mergedList.get(n / 2) + mergedList.get((n / 2) - 1)) / 2.0;
        } else {
            return mergedList.get(n / 2);
        }
    }
}
