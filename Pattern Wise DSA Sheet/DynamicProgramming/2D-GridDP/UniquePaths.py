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
