public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s="babda";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s){
        int st=0,len=1;
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]==1)){
                    dp[i][j]=1;
                    if(len<j-i+1){
                        len=j-i+1;
                        st=i;
                    }
                }
            }
        }
        return s.substring(st,st+len);
    }
}
