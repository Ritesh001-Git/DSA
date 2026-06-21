// TC - O(n)
// SC - O(1)

// Java Code

class Solution {
    public int trap(int[] nums) {
        int i=0,j=nums.length-1;
        int lmax=nums[i],rmax=nums[j];
        int water=0;
        while(i<j){
            if(lmax<rmax){
                i++;
                lmax=Math.max(lmax,nums[i]);
                water+=(lmax-nums[i]);
            }else{
                j--;
                rmax=Math.max(rmax,nums[j]);
                water+=(rmax-nums[j]);
            }
        }
        return water;

    }
}


// Python Code

class Solution:
    def maxWater(self, arr):
        # code here
        i, j = 0, len(arr) - 1
        
        lmax, rmax = arr[i], arr[j]
        
        water = 0
        
        while i < j:
            if lmax < rmax:
                i += 1
                lmax = max(lmax, arr[i])
                water += lmax - arr[i]
            else:
                j -= 1
                rmax = max(rmax, arr[j])
                water += rmax - arr[j]
                
        return water
