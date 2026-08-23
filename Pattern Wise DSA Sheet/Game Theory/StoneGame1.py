# TC - O(n^2)
# SC - O(n^2)

from functools import lru_cache
class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        n = len(piles)

        @lru_cache(None)
        def solve(i, j):
            if i > j: return 0
            # if i == j: return piles[i]

            take_i = piles[i] - solve(i+1, j)
            take_j = piles[j] - solve(i, j-1)

            return max(take_i, take_j)

        return solve(0, n-1) > 0
