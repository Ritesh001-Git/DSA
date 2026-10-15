# //Approach-1 (Recur + Memo)

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if(n==1): return nums[0]

        dp1 = [-1] * (n + 1)
        dp2 = [-1] * (n + 1)

        def solve(idx, end, dp):
            if idx > end: return 0

            if dp[idx] != -1: return dp[idx]

            take = nums[idx] + solve(idx + 2, end, dp)
            skip = solve(idx + 1, end, dp)

            dp[idx] = max(take, skip)
            return dp[idx]

        return max(solve(0, n-2, dp1), solve(1, n-1, dp2))
        
