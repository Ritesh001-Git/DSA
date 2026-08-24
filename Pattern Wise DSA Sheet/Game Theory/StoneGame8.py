from functools import lru_cache
class Solution:
    def stoneGameVIII(self, stones: List[int]) -> int:
        n = len(stones)

        preSum = [0] * n
        preSum[0] = stones[0]

        for i in range(1,n):
            preSum[i] = preSum[i - 1] + stones[i]

        @lru_cache
        def solve(idx):
            if idx == n - 1:
                return preSum[idx]

            take = preSum[idx] - solve(idx + 1)
            skip = solve(idx + 1)

            return max(take, skip)

        return solve(1)
