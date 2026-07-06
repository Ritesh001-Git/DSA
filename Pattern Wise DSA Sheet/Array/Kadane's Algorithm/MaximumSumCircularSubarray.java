// TC - O(n)
// SC - O(1)

// Java Code

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = -(int) Math.pow(10, 5);
        int curr1 = 0;
        int minSum = (int) Math.pow(10, 5);
        int curr2 = 0;
        int total = 0;

        for (int i : nums) {
            total += i;

            curr1 += i;
            maxSum = Math.max(maxSum, curr1);
            if (curr1 < 0) curr1 = 0;

            curr2 += i;
            minSum = Math.min(minSum, curr2);
            if (curr2 > 0) curr2 = 0;
        }

        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}

// Python Code

class Solution(object):
    def maxSubarraySumCircular(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        maxSum = -(10 ** 5)
        curr1 = 0
        minSum = 10 ** 5
        curr2 = 0

        for i in nums:
            curr1 += i
            maxSum = max(maxSum, curr1)
            if curr1 < 0: curr1 = 0

            curr2 += i
            minSum = min(minSum, curr2)
            if curr2 > 0: curr2 = 0

        if maxSum < 0: return maxSum

        if sum(nums) > maxSum: return sum(nums)
        
        return max(sum(nums) - minSum, maxSum)
        
