class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp = [-1] * (len(nums) + 1)
        
        def solve(i):
            if i >= len(nums): return 0

            if dp[i] != -1: return dp[i]

            take = nums[i] + solve(i+2)
            skip = solve(i+1)

            dp[i] = max(take,skip)

            return max(take,skip)

        return solve(0)
        
        
