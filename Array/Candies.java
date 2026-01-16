import java.util.*;
public class Candies {
    public static void main(String[] args) {
        int[] nums={1,2,0};
        System.out.println(candy(nums));
    }
    public static int candy(int[] nums){
        int n=nums.length;
        int[] count=new int[n];
        Arrays.fill(count,1);
        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1]) count[i]=count[i-1]+1;
        }
        for(int i=n-2; i>=0; i--){
            if(nums[i]>nums[i+1]) count[i]=Math.max(count[i],count[i+1]+1);
        }
        int sum=0;
        for(int i:count) sum+=i;
        return sum;
    }
}
