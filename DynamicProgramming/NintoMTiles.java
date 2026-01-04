
import java.util.Arrays;

public class NintoMTiles {
    public static void main(String[] args) {
        int n=487;
        int m=88;
        System.out.println(countWays(n,m));
    }
    public static int countWays(int n,int m){
        int[] dp=new int[n+1];
        if(n<m) return 1;
        Arrays.fill(dp,1);
        for(int i=m; i<=n; i++){
            dp[i]=(dp[i-m]+dp[i-1])%1000000007;
        }
        return dp[n];
    }
}
