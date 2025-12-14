import java.util.*;
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
        System.out.println(rob2(nums));
    }

    // Dynamic Programming Memoization(Top-Down)
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

    // Tabulation DP (Bottom-Up DP)
    public static int rob2(int[] nums){
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2; i<=nums.length; i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
         return dp[nums.length];
    }
}
