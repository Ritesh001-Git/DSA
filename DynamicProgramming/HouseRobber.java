import java.util.*;
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
    public static int solve(int i,int[] nums,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];

        int take=nums[i]+solve(i+2,nums,dp);
        int skip=solve(i+1,nums,dp);

        return dp[i]=Math.max(take,skip);
    }
}
