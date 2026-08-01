# TC - O(n)
# SC - O(n)

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        mp = {}
        mp[0] = 1

        s,c = 0, 0

        for i in range(len(nums)):
            s += nums[i]

            if s-k in mp:
                c += mp[s-k]

            mp[s] = mp.get(s, 0) + 1

        return c

        
