public class ClimbingStairs {
    public static void main(String[] args) {
        int n=5;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        int dp[]=new int[n+1];
        return fibo(n,dp);
    }
    public static int fibo(int n,int[] dp){
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];
        dp[n]=fibo(n-2,dp)+fibo(n-1,dp);
        return dp[n];
    }
}
