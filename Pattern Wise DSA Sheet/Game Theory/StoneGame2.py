# TC - O(n^2)
# SC - O(n^2)


from functools import lru_cache
class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        suffix = [0] * (n + 1)

        for i in range(n - 1, -1, -1):
            suffix[i] = suffix[i + 1] + piles[i]

        @lru_cache(None)
        def solve(idx, m):
            if idx >= n: return 0

            take = 0

            for x in range(1, m*2+1):
                if idx + x > n:
                    break

                # Stones remaining after taking x
                opponent = solve(idx + x, max(m,x))

                # Total remaining - what opponent can get
                curr = suffix[idx] - opponent

                take = max(take, curr)

            return take

        return solve(0, 1)
