# Approach 1 - Recursion + memo
# TC - O(n^2)
# SC - O(n^2)

from functools import lru_cache
class Solution:
    def canCross(self, stones: list[int]) -> bool:
        n = len(stones)

        if n == 1:
            return True

        if stones[1] != 1:
            return False

        mp = {stones[i]: i for i in range(n)}

        @lru_cache(None)
        def solve(idx, k):
            if idx >= n or idx < 0 or k < 0: return False

            if idx == n - 1: return True

            if stones[idx] + k in mp:
                if solve(mp[stones[idx] + k], k): return True
            
            if stones[idx] + k + 1 in mp:
                if solve(mp[stones[idx] + k + 1], k + 1): return True

            if stones[idx] + k - 1 in mp and k - 1 > 0:
                if solve(mp[stones[idx] + k - 1], k - 1): return True

            return False

        return solve(1, 1)
