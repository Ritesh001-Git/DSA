import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        System.out.println(minDistanceRecursion(word1,word2));
        System.out.println(minDistance(word1,word2));
        System.out.println(minDistance1(word1,word2));     
    }

    // Recursion (TLE)
    public static int minDistanceRecursion(String word1,String word2){
        return solveRecursion(0,0,word1,word2);
    }
    public static int solveRecursion(int i,int j,String word1,String word2){
        if(word1.length()==i) return word2.length()-j;
        if(word2.length()==j) return word1.length()-i;
        if(word1.charAt(i)==word2.charAt(j)) return solveRecursion(i+1,j+1,word1,word2);
        return 1+Math.min(solveRecursion(i+1,j+1,word1, word2),Math.min(solveRecursion(i+1,j,word1,word2),solveRecursion(i,j+1,word1,word2)));
    }

    // Dynamic Programming Memoization(Top-Down)
    public static int minDistance(String word1,String word2){
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,0,word1,word2,dp);
    }
    public static int solve(int i,int j,String word1,String word2,int[][] dp){
        if(word1.length()==i) return word2.length()-j;
        if(word2.length()==j) return word1.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) return dp[i][j]=solve(i+1,j+1,word1,word2,dp);
        return dp[i][j]=1+Math.min(solve(i+1,j+1,word1, word2,dp),Math.min(solve(i+1,j,word1,word2,dp),solve(i,j+1,word1,word2,dp)));
    }

    // Tabulation DP (Bottom-Up DP)
    public static int minDistance1(String word1,String word2){
        int m=word1.length(),n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[0][i]=i;
        }
        for(int j=0; j<=n; j++){
            dp[j][0]=j;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}
