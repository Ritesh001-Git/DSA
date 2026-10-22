class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        from functools import lru_cache
        n = len(energy)

        @lru_cache(None)
        def solve(idx):
            if idx >= n or idx < 0: return 0

            return energy[idx] + solve(idx + k)

        m = float('-inf')

        for i in range(n):
            m = max(m, solve(i))

        return m

