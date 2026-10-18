# TC - O(n * sqrt(n))
# SC - O(n)

import math
from functools import lru_cache
class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        
        @lru_cache(None)
        def solve(curr):
            # If curr == 0 that means alice looses
            if curr == 0:
                return False

            for i in range(1, math.isqrt(curr) + 1):
                
                # If next player losses that means alice won
                if not solve(curr - (i * i)):
                    return True

            # Bob wins
            return False

        return solve(n)
