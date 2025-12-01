import java.util.Arrays;

public class FibonacciNumber{
    public static void main(String[] args) {
        int n=5;
        System.out.println(fibo1(n));

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibo2(n,dp));

        System.out.println(fibo3(n));
    }
    // Recursive Approach
    public static int fibo1(int n){
        if(n==1 || n==0) return n;
        return fibo1(n-2)+fibo1(n-1);
    }

    // Dynamic Programming Memoization(Top-Down)
    public static int fibo2(int n,int[] dp){
        if(n==1 || n==0) return n;
        if(dp[n]!=-1) return n;
        return fibo2(n-2,dp)+fibo2(n-1,dp);
    }

    // Tabulation DP (Bottom-Up DP)
    public static int fibo3(int n) {
        if(n==0 || n==1) return n;
        int f=0,s=1;
        for(int i=1; i<=n; i++){
            int third=f+s;
            f=s;
            s=third;
        }
        return f;
    }
}