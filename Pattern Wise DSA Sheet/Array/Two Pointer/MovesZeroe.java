// TC - O(n)
// SC = O(1)

// Java Code

class Solution {
    public void moveZeroes(int[] nums) {
        int j=0,i=0;
        if(nums.length==1) return;
        while(j<nums.length){
            if(nums[j]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }
}



// Puthon Code

class Solution:
    def moveZeroes(self, nums: list[int]) -> None:
        j = 0
        i = 0
        if len(nums) == 1:
            return
        while j < len(nums):
            if nums[j] != 0:
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                i += 1
            j += 1
