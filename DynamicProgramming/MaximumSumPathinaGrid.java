import java.util.*;
public class MaximumSumPathinaGrid {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[][] grid=new long[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j]=sc.nextInt();
            }
        }
        long[][] dp=new long[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Long.MIN_VALUE);
        long sum=solve(dp,grid,0,0,n);
        System.out.println(sum);
        sc.close();
        System.out.println(Arrays.deepToString(dp));
    }

    // Dynamic Programming Memoization(Top-Down)
    public static long solve(long[][] dp,long[][] grid,int i,int j,int n){
        if(i==n-1 && j==n-1) return grid[i][j];
        if(i>=n || j>=n) return Long.MIN_VALUE;
        if(dp[i][j]!=Long.MIN_VALUE) return dp[i][j];

        long down=solve(dp,grid,i+1,j,n);
        long right=solve(dp,grid,i,j+1,n);

        return dp[i][j]=grid[i][j]+Math.max(down,right);
    }
}
