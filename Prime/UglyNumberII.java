public class UglyNumberII {
    public static void main(String[] args) {
        int n=10;
        System.out.println(nthUglyNumber(n));
    }
    public static int nthUglyNumber(int n){
        int[] dp=new int[n];
        dp[0]=1;
        int n2=0,n3=0,n5=0;
        for(int i=1; i<n; i++){
            int two=dp[n2]*2;
            int three=dp[n3]*3;
            int five=dp[n5]*5;
            dp[i]=Math.min(two,Math.min(three,five));
            if(dp[i]==two) n2++;
            if(dp[i]==three) n3++;
            if(dp[i]==five) n5++;
        }
        return dp[n-1];
    }
}
