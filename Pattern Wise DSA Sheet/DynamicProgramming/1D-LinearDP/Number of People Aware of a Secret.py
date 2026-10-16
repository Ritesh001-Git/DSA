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

# Approach 2 - Bottom Up

class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        MOD = 10 ** 9 + 7

        dp = [0] * (n + 1)
        dp[1] = 1

        for day in range(2, n + 1):
            c = 0
            for i in range(max(1, day - forget + 1), day - delay + 1):
                c = (c + dp[i]) % MOD
            dp[day] = c

        ans = 0

        for day in range(max(1, n - forget + 1), n + 1):
            ans = (ans + dp[day]) % MOD

        return ans
