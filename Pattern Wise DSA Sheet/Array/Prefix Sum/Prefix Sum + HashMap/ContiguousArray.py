# TC - O(n)
# SC - O(n)

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)

        mp = {0:-1}

        sum = 0
        ans = 0

        for i in range(n):
            if nums[i] == 0:
                sum -= 1
            else:
                sum += 1
            
            if sum in mp:
                ans = max(ans, i - mp[sum])
            else:
                mp[sum] = i

        return ans
