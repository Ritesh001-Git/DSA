import java.util.Arrays;

public class FibonacciNumber{
    public static void main(String[] args) {
        int n=5;
        System.out.println(fibo1(n));

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibo2(n,dp));
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

}