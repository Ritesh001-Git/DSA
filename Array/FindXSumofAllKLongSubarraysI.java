import java.util.*;

public class FindXSumofAllKLongSubarraysI {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,2,3};
        int k = 6;
        int x = 2;
        int[] ans = findXSum(arr, k, x);
        System.out.println(Arrays.toString(ans)); // Output: [8, 11, 14]
    }
    public static int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        for(int i=0; i<=n-k; i++){
            Map<Integer,Integer> mp=new HashMap<>();
            for(int j=i; j<i+k; j++){
                mp.put(nums[i],mp.getOrDefault(nums[j],0)+1);
            }
            List<Integer> l=new ArrayList<>(mp.keySet());
            l.sort((a,b)->mp.get(b)==mp.get(a)?b-a:mp.get(b)-mp.get(a));
            int sum=0;
            for(int j=0; j<Math.min(x,l.size()); j++){
                sum+=l.get(j);
            }
            res[i]=sum;
        }
        return res;
    }
}
