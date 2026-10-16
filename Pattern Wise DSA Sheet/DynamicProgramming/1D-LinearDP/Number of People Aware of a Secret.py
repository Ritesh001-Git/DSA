# Approach 1 - Recursion + memo

class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        from functools import lru_cache

        MOD = 10 ** 9 + 7

        # For total people in nth day the range n - forget + 1 to n - delay
        @lru_cache(None)
        def solve(day):
            if day == 1: return 1

            total = 0

            for i in range(max(1, day - forget + 1), day - delay + 1):
                total = (total + solve(i)) % MOD

            return total
        
        ans = 0

        for day in range(n - forget + 1, n + 1):
            ans = (ans + solve(day)) % MOD

        return ans

        
