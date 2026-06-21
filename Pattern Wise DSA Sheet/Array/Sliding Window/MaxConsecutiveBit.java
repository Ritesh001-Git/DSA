// TC - O(n)
// SC - O(1)

// Max Consecutive Bit

// Java Code
class Solution {
    public int maxConsecBits(int[] arr) {
        // code here
        int one=0,zero=0;
        int o=0,z=0;
        for(int x=0; x<arr.length; x++){
            
            if(arr[x]==0){
                z++;
                o=0;
                zero=Math.max(z,zero);
            }else{
                o++;
                z=0;
                one=Math.max(o,one);
            }
            
        }
        return Math.max(one,zero);
    }
}

// Python Code
class Solution:
    def maxConsecBits(self, arr):
        code here 
        n = len(arr)
        
        o, z = 0, 0
        one ,zero = 0, 0
        
        for i in range(n):
            if arr[i] == 0:
                o += 1
                z = 0
                one = max(one, o)
            else:
                z += 1
                o = 0
                zero = max(zero, z)
                
        return max(one, zero)

// Max Consecutive Ones (LeetCode)

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0;
        int max=0;
        for(int i:nums){
            if(i==1) c++;
            else{
                max=Math.max(c,max);
                c=0;
            }
        }
        max=Math.max(c,max);
        return max;
    }
}
  
