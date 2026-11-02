class Solution:
    def maximumPath(self, mat):
        # code here
        m, n = len(mat), len(mat[0])
        
        dp = [[-1] * (n+1) for _ in range(m + 1)]
        
        def solve(i, j):
            if j < 0 or j >= n:
                return float('-inf')

            if i == 0:
                return mat[0][j]
                
            if dp[i][j] != -1: return dp[i][j]
                
            dp[i][j] = mat[i][j] + max(
                solve(i - 1, j),      # up
                solve(i - 1, j - 1),  # up-left
                solve(i - 1, j + 1)   # up-right
            )
            
            return dp[i][j]
            
        ans = 0
        for j in range(n):
            ans = max(ans, solve(m - 1, j))

        return ans
        
