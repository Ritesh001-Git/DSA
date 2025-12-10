public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(rob(nums));
    }

    // Tabulation DP (Bottom-Up DP)
    public static int rob(int[] nums){
        if(nums.length==1) return 0;
        int n=nums.length;
        return Math.max(solve(nums,0,n-2),solve(nums,1,n-1));
    }
    public static int solve(int[] nums,int st,int end){
        int len=end-st+1;
        int[] dp=new int[len+1];
        dp[0]=0;
        dp[1]=nums[st];
        for(int i=2; i<=len; i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[st+i-1]);
        }
        return dp[len];
    }
}
