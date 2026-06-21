// TC - O(n)
// SC - O(n)

// Java Code

class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int area=0;
        while(i<=j){
            if(height[i]>height[j]){
                area=Math.max(area,height[j]*(j-i));
                j--;
            }else{
                area=Math.max(area,height[i]*(j-i));
                i++;
            }
        }
        return area;
    }
}

// Python Code

class Solution:
    def maxWater(self, arr):
        # code here
        i, j = 0, len(arr) - 1
        
        water = 0
        
        while i < j:
            if arr[i] < arr[j]:
                water = max(water, arr[i] * (j-i))
                i += 1
            else:
                water = max(water, arr[j] * (j-i))
                j -= 1
                
        return water;
