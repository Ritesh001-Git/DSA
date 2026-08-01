# TC = O(n)
# SC = O(n)

class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        total = sum(nums)

        if total % p == 0: return 0

        target = total % p

        curr = 0

        mp = {0:-1}

        ans = len(nums)

        for i in range(len(nums)):
            curr = (curr + nums[i]) % p
            remain = (curr - target + p) % p

            if remain in mp:
                ans = min(ans, i - mp[remain])

            mp[curr] = i

        return ans if ans < len(nums) else -1
