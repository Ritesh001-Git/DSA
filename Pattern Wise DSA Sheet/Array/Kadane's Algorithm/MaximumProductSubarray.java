// S

// Java Code

class Solution {
    public int maxProduct(int[] nums) {
        int p=1,max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            p*=nums[i];
            max=Math.max(p,max);
            if(p==0) p=1;
        }
        p=1;
        for(int i=nums.length-1; i>=0; i--){
            p*=nums[i];
            max=Math.max(p,max);
            if(p==0) p=1;
        }
        return max;
    }
}

// Python Code

class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        curr = 1
        maxP = -(10 ** 5)

        for i in nums:
            curr *= i
            maxP = max(maxP, curr)
            if curr == 0: curr = 1

        curr = 1

        for i in range(len(nums)-1, -1, -1):
            curr *= nums[i]
            maxP = max(maxP, curr)
            if curr == 0: curr = 1

        return maxP
        
