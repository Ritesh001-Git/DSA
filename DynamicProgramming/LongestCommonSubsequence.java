import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        // System.out.print(longestCommonSubsequence(text1,text2));
        System.out.print(longestCommonSubsequence1(text1,text2));
    }

    // // Recursion (TLE)
    // public static int longestCommonSubsequence(String text1,String text2){
    //     int n1=text1.length(),n2=text2.length();
    //     return lcsRecursion(n1, n2, text1, text2);
    // }
    // public static int lcsRecursion(int i,int j,String text1,String text2){
    //     if(i<0 || j<0) return 0;
    //     if(text1.charAt(i)==text2.charAt(j)) return 1+lcsRecursion(i-1,j-1,text1,text2);
    //     return Math.max(lcsRecursion(i,j-1,text1,text2),lcsRecursion(i-1,j,text1,text2));
    // }

    // Dynamic Programming Memoization(Top-Down)
    public static int longestCommonSubsequence1(String text1,String text2){
        int n1=text1.length(),n2=text2.length();
        int[][] dp=new int[n1+1][n2+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return lcs(n1-1,n2-1,text1,text2,dp);
    }
    public static int lcs(int i,int j,String text1,String text2,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)) return 1+lcs(i-1,j-1,text1,text2,dp);
        return dp[i][j]=Math.max(lcs(i,j-1,text1,text2,dp),lcs(i-1,j,text1,text2,dp));
    }
}
