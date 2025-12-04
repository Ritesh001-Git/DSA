import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=3;
        System.out.println(subarraySum(nums,k));
    }
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
}
