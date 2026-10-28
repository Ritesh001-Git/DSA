# R = number of rows, C = number of columns, and K = 1024 = number of possible XOR states.
# TC - O(R * C * K)

# Approach 1 - Memo + Recursion

# Python Code
from array import array

class Solution:
    def minCost(self, grid: list[list[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        X = 1024

        dp = array('i', [-1]) * (n * m * X)
        INF = 10**9

        def solve(i, j, xor):
            if i >= n or j >= m:
                return INF

            xor ^= grid[i][j]

            if i == n - 1 and j == m - 1:
                return xor

            idx = (i * m + j) * X + xor

            if dp[idx] != -1:
                return dp[idx]

            right = solve(i, j + 1, xor)
            down = solve(i + 1, j, xor)

            dp[idx] = min(right, down)
            return dp[idx]

        return solve(0, 0, 0)

# Java Code
class Solution {
    
    public int solve(int[][] grid,int i,int j,int xor,int[][][] dp){
        if(i<0 || j<0) return Integer.MAX_VALUE;
        
        xor^=grid[i][j];

        if(i==0 && j==0) return xor;

        if(dp[i][j][xor]!=-1) return dp[i][j][xor];

        int up=solve(grid,i-1,j,xor,dp);
        int left=solve(grid,i,j-1,xor,dp);

        return dp[i][j][xor]=Math.min(up,left);
    }
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m+1][n+1][1024];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(grid,m-1,n-1,0,dp);
    }
}
