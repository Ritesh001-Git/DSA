# Approach 1: Recursion + Memoization (Top-Down DP)
# Time Complexity: O(m * n)
# Space Complexity: O(m * n) - Cache + Recursion Stack

from functools import lru_cache
from typing import List

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        @lru_cache(maxsize=None)
        def solve(r: int, c: int) -> int:
            if r < 0 or c < 0:
                return 0
            if r == 0 and c == 0:
                return 1
            return solve(r - 1, c) + solve(r, c - 1)

        return solve(m - 1, n - 1)


# Approach 2: Tabulation (Bottom-Up DP)
# Time Complexity: O(m * n)
# Space Complexity: O(m * n) - 2D DP Array

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for _ in range(m)]

        dp[0][0] = 1

        for r in range(m):
            for c in range(n):
                if r == 0 and c == 0:
                    continue

                up = dp[r - 1][c] if r > 0 else 0
                left = dp[r][c - 1] if c > 0 else 0

                dp[r][c] = up + left

        return dp[m - 1][n - 1]


# Approach 3: Space Optimisation (1D DP)
# Time Complexity: O(m * n)
# Space Complexity: O(n) - 1D DP Array

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1] * n

        for r in range(1, m):
            for c in range(1, n):
                dp[c] = dp[c] + dp[c - 1]

        return dp[n - 1]


# Approach 4: Combinatorics (Mathematical Approach)
# Time Complexity: O(min(m, n)) - Using math.comb
# Space Complexity: O(1) - Auxiliary Space

import math

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return math.comb(m + n - 2, m - 1)
