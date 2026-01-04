public class DominoandTrominoTiling {
    public static void main(String[] args) {
        int n=29;
        System.out.println(numTilings(n));
    }
    public static int numTilings(int n){
        int mod=1000000007;
        if(n<=1) return 1;
        if(n==2) return 2;
        if(n==3) return 5;
        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;dp[2]=2;dp[3]=5;
        for(int i=4; i<=n; i++){
            dp[i]=(int)(2*dp[i-1]%mod+dp[i-3]%mod);
        }
        return dp[n];
    }
}
