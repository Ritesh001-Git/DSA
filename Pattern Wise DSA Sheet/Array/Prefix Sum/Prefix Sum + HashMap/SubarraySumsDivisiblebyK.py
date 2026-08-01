class Solution(object):
    def subarraysDivByK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        mp = {0:1}

        c = 0
        p = 0

        for i in range(len(nums)):
            p += nums[i]
            remainder = p % k

            if remainder < 0:
                remainder += k

            if remainder in mp:
                c += mp.get(remainder)

            mp[remainder] = mp.get(remainder,0) + 1

        return c
            
        
