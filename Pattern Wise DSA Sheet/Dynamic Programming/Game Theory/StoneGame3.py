# TC - O(n)
# SC - O(n)

from functools import lru_cache
class Solution:
    def stoneGameIII(self, nums: List[int]) -> str:
        n = len(nums)

        @lru_cache(None)
        def solve(i):

            if i >= n: return 0

            take_1 = nums[i] - solve(i+1)
            
            take_2 = float("-inf")
            if i + 1 < n: take_2 = nums[i] + nums[i+1] - solve(i+2)

            take_3 = float("-inf")
            if i + 2 < n: take_3 = nums[i] + nums[i+1] + nums[i+2] - solve(i+3)

            return max(take_1, take_2, take_3)

        alice_diff_bob = solve(0)

        if alice_diff_bob == 0: return "Tie"
        return "Alice" if alice_diff_bob > 0 else "Bob"
