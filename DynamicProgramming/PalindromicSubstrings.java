public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s="aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s){
        int c=0,n=s.length();
        int[][] dp=new int[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]==1)){
                    c++;
                    dp[i][j]=1;
                }
            }
        }
        return c;
    }
}
