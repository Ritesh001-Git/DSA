# Java Code
# Approach: Memo + Recursion (Top-Down DP)
# Time Complexity: O(m * n)
# Space Complexity: O(m * n)
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

# Python Code
# Approach: Memo + Recursion (Top-Down DP)
# Time Complexity: O(m * n)
# Space Complexity: O(m * n)

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

# Approach: Tabulation (Bottom-Up DP)
# Time Complexity: O(m * n)
# Space Complexity: O(m * n)

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: list[list[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        if obstacleGrid[0][0] == 1:
            return 0

        dp = [[0] * n for _ in range(m)]

        dp[0][0] = 1

        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue

                if obstacleGrid[i][j] == 1:
                    continue

                up = dp[i - 1][j] if i > 0 else 0
                left = dp[i][j - 1] if j > 0 else 0

                dp[i][j] = up + left

        return dp[m - 1][n - 1]


# Approach: Space Optimisation (1D DP)
# Time Complexity: O(m * n)
# Space Complexity: O(n)

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: list[list[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])

        dp = [0] * n
        dp[0] = 1

        for i in range(m):
            for j in range(n):
                if obstacleGrid[i][j] == 1:
                    dp[j] = 0
                elif j > 0:
                    dp[j] += dp[j - 1]

        return dp[n - 1]
