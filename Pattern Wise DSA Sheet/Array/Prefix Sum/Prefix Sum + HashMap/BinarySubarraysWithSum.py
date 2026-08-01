# TC - O(n)
# SC - O(n)

class Solution(object):
    def numSubarraysWithSum(self, nums, goal):
        """
        :type nums: List[int]
        :type goal: int
        :rtype: int
        """
        n = len(nums)
        currSum = 0
        c =0

        mp = {0:1}

        for i in range(n):
            currSum += nums[i]

            if currSum - goal in mp:
                c += mp[currSum - goal]
            
            mp[currSum] = mp.get(currSum,0) + 1

        return c
