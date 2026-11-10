# Approach 1 - Recursion + memo
# Time complexity: O(n)
# Space complexity: O(n)

from functools import lru_cache
class Solution:
    def climbStairs(self, n: int, costs: List[int]) -> int:

        @lru_cache(None)
        def solve(idx):
            if idx >= n: return 0

            one = float('inf')
            if idx < n:
                one = costs[idx] + 1 + solve(idx + 1)

            two = float('inf')
            if idx + 1 < n:
                two = costs[idx + 1] + 4 + solve(idx + 2)

            three = float('inf')
            if idx + 2 < n:
                three = costs[idx + 2] + 9 +  solve(idx + 3)

            return min(one, two, three)

        return solve(0)
