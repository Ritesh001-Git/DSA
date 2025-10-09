import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(arr, target);
        System.out.println("Indices: " + ans[0] + ", " + ans[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff=target-nums[i];
            if(mp.containsKey(diff)){
                return new int[] {mp.get(diff),i};
            }else{
                mp.put(nums[i],i);
            }
        }
        return new int[] {-1,-1};
    }
}
