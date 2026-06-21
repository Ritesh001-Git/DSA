// TC - O(n)
// SC - O(1)

// Java Code

class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int max=0,count0=0;
        while(j<nums.length){
            if(nums[j]==0) count0++;
            while(count0>k){
                if(nums[i]==0) count0--;
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}

// Python Code

class Solution(object):
    def longestOnes(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        zero = 0
        j = 0

        maxOne = 0

        for i in range(len(nums)):
            if nums[i] == 0: zero += 1

            while zero > k:
                if nums[j] == 0: zero -= 1
                j += 1
            
            maxOne = max(maxOne, i - j + 1)

        return maxOne
