# TC - O(n)
# SC - O(n)

# Python Code

class Solution(object):
    def maxSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        n = len(nums)
        arr = [0] * n
        arr[0] = nums[0]

        for i in range(1,n):
            arr[i] = nums[i] + arr[i-1]

        maxSum = -(10 ** 18)

        for st in range(k):
            currSum = 0

            i = st
            while i + k - 1 < n and i < n:
                j = i + k - 1

                currSub = arr[j] - arr[i - 1] if i > 0 else arr[j]
                
                currSum = max(currSub, currSub + currSum)

                maxSum = max(currSum, maxSum)

                i += k

        return maxSum
