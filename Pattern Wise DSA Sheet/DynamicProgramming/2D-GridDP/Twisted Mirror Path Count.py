# Approach 1: Recursion + Memoization (Top-Down DP)
# Time Complexity: O(m * n * (m + n))
# Space Complexity: O(m * n)

from functools import lru_cache
class Solution:
    def uniquePaths(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        if grid[0][0] == 1 or grid[-1][-1] == 1: return 0

        MOD = 10 ** 9 + 7

        @lru_cache(None)
        def solve(i, j):
            if i >= m or j >= n: return 0

            if i == m - 1 and j == n - 1: return 1

            x, y = i, j + 1
            direction = 0
            while x < m and y < n and grid[x][y] == 1:
                if direction == 0:
                    x += 1
                    direction = 1
                else:
                    y += 1
                    direction = 0

            r = solve(x, y) if x < m and y < n else 0

            x, y = i + 1, j
            direction = 1
            while x < m and y < n and grid[x][y] == 1:
                if direction == 0:
                    x += 1
                    direction = 1
                else:
                    y += 1
                    direction = 0

            d = solve(x, y) if x < m and y < n else 0

            return (r + d) % MOD

        return solve(0, 0) % MOD
