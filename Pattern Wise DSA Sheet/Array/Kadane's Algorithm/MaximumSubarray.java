// TC - O(n)
// SC - O(1)

// Java Code

class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int curr=0;
        for(int i:nums){
            curr+=i;
            max=Math.max(max,curr);
            if(curr<0) curr=0;
        }
        return max;
    }
}

// Python Code
class Solution(object):
    def maxSubArray(self, nums):
        maxSum = max(nums)
        curr = 0

        for i in nums:
            curr += i
            maxSum = max(maxSum,curr)
            if curr < 0: curr = 0
        
        return maxSum
        
