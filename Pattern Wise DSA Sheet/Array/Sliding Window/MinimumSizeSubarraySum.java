// TC - O(n)
// SC - O(1)

// Java Code
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int s=0;
        int max=Integer.MAX_VALUE,j=0;
        for(int i=0; i<nums.length; i++){
            s+=nums[i];
            while(s>=target){
                max=Math.min(max,i-j+1);
                s-=nums[j++];
            }
        }
        return max==Integer.MAX_VALUE?0:max;
    }
}

// Python Code
class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        sum, j = 0, 0
        maxLen = float('inf')

        for i in range(len(nums)):
            sum += nums[i]

            while sum >= target:
                maxLen = min(maxLen, i - j + 1)
                sum -= nums[j]
                j += 1

        return 0 if maxLen == float('inf') else maxLen
