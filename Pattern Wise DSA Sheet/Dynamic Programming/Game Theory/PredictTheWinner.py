# TC - O(n^2)
# SC = O(n^2)

# Arpproach 1

from functools import lru_cache
class Solution:
    def predictTheWinner(self, nums: List[int]) -> bool:
        total = sum(nums)

        @lru_cache(None)
        def solve(i, j):
            if i > j: return 0
            if i == j: return nums[i]

            take_i = nums[i] - solve(i+1, j)
            take_j = nums[j] - solve(i, j-1)

            return max(take_i, take_j)

        return solve(0, len(nums) - 1) >= 0


# Arrroach 2

from functools import lru_cache
class Solution:
    def predictTheWinner(self, nums: List[int]) -> bool:
        total = sum(nums)

        @lru_cache(None)
        def solve(i, j):
            if i > j: return 0
            if i == j: return nums[i]

            take_i = nums[i] + min(solve(i+2, j), solve(i+1, j-1))
            take_j = nums[j] + min(solve(i, j-2), solve(i+1, j-1))\

            return max(take_i, take_j)

        a = solve(0, len(nums) - 1)
        b = total - a

        return True if a >= b else False
