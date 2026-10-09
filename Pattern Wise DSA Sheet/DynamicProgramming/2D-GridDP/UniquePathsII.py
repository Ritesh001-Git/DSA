# Java Code
class Solution {
    public int solve(int[][] grid,int m,int n,int[][] dp){
        if(m<0 || n<0) return 0;
        if(m==0 && n==0) return 1;
        if(grid[m][n]==1) return 0;

        if(dp[m][n]!=-1) return dp[m][n];

        int left=solve(grid,m,n-1,dp);
        int up=solve(grid,m-1,n,dp);

        return dp[m][n]=left+up;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        if(grid[0][0]==1) return 0;
        return solve(grid,m-1,n-1,dp);
    }
}

## Python Code
from functools import lru_cache
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: list[list[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        @lru_cache(maxsize=None)
        def solve(r, c):
            if r < 0 or c < 0:
                return 0
            if obstacleGrid[r][c] == 1:
                return 0
            if r == 0 and c == 0:
                return 1
            return solve(r - 1, c) + solve(r, c - 1)

        return solve(m - 1, n - 1)
