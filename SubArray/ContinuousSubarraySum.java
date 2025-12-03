
import java.util.*;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums={23,2,6,4,7};
        int k=3;
        System.out.println(checkSubarraySum(nums,k));
    }
    public static boolean checkSubarraySum(int[] nums,int k){
        int sum=0;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            sum%=k;
            if(mp.containsKey(sum)){
                if(i-mp.get(sum)>1) return true;
            }else{
                mp.put(sum,i);
            }
        }
        return false;
    } 
}
