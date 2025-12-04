import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums={1,2,1,5,4,-4,3,5,6,3,2,4,4};
        int k=9;
        System.out.println(subarraySum(nums,k));
        System.out.println(subarraySum1(nums,k));
    }

    // HashMap Approach
    public static int subarraySum(int[] nums,int k){
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int c=0;
        int sum=0;
        for(int i:nums){
            sum+=i;
            if(mp.containsKey(sum-k)){
                c+=mp.get(sum-k);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return c;
    }

    // Brute Force Approach
    public static int subarraySum1(int[] nums,int k){
        int c=0;
        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];
                if(sum==k) c++;
            }
        }
        return c;
    }
}
