import java.util.*;

public class CountPairsWhoseSumIsLessThanTarget {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 7;
        int count = countPairs(arr, target);
        System.out.println("Count of pairs whose sum is less than " + target + ": " + count);
        Arrays.sort(arr);
    }
    static int countPairs(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1,c=0;
        while(i<j){
            if(nums[i]+nums[j]<target){
                c+=j-i;
                i++;
            }
            else j--;
        }
        return c;
      }
}
