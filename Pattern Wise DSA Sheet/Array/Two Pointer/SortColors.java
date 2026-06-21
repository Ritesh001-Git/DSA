// TC - O(n)
// SC - O(1)

// Java Code
class Solution {
    public void sortColors(int[] nums) {
        int i=0,m=0,j=nums.length-1;
      
        while(m<=j){
          
            if(nums[m]==0){
                int t=nums[m];
                nums[m]=nums[i];
                nums[i]=t;
                m++;
                i++;
            }
            else if(nums[m]==2){
                int t=nums[m];
                nums[m]=nums[j];
                nums[j]=t;
                j--;
            }
            else{
                m++;
            }
        }
    }
}

// Python Code

class Solution(object):
    def sortColors(self, arr):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """

        i, j, k = 0, 0, len(arr) - 1
        
        while j <= k:
            
            if arr[j] == 0:
                arr[j], arr[i] = arr[i], arr[j]
                i += 1
                j += 1
            elif arr[j] == 2:
                arr[j], arr[k] = arr[k], arr[j]
                k -= 1
            else:
                j += 1
        
        return arr
        
