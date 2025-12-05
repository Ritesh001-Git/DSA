import java.util.Arrays;

public class nCr {
    public static void main(String[] args) {
        int n=10;
        int r=5;
        System.out.println(calculateNCr(n,r));
        System.out.println(calculateNCr1(n,r));
    }

    // Dynamic Programming Memoization(Top-Down)
    public static int calculateNCr(int n,int r){
        int[][] dp=new int[n+1][r+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(n,r,dp);
    }
    public static int solve(int n,int r,int[][] dp){
        if(r==0 || r==n) return 1;
        if(r>n) return 0;
        if(dp[n][r]!=-1) return dp[n][r];
        dp[n][r]=solve(n-1,r-1,dp)+solve(n-1,r,dp);
        return dp[n][r];
    }

    // Tabulation DP (Bottom-Up DP)
    public static int calculateNCr1(int n,int r){
        int[][] dp=new int[n+1][r+1];
        for(int[] i:dp){
            Arrays.fill(i,0);
        }
        for(int i=0; i<=n; i++){
            dp[i][0]=1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=r; j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        return dp[n][r];
    }
}
