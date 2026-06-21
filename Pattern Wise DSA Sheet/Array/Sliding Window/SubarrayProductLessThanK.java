// TC - O(n)
// SC - O(1)

// Java Code
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int i=0,j=0;
        int p=1,c=0;
        while(j<nums.length){
            p=p*nums[j];
            while(p>=k){
                p/=nums[i];
                i++;
            }
            c+=j-i+1;
            j++;
        }
        return c;
    }
}

// Python Code
class Solution(object):
    def numSubarrayProductLessThanK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if k <= 1:
            return 0
        p = 1
        c = 0
        j = 0

        for i in range(len(nums)):
            p = p * nums[i]

            while p >= k:
                p //= nums[j]
                j += 1

            c += (i - j + 1)

        return c
