// TC - O(n)
// SC - O(1)

// Jva Code
class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        int max=Integer.MIN_VALUE;
        int s=0;
        for(int i=0; i<k; i++){
            s+=arr[i];
        }
        max=Math.max(max,s);
        for(int i=1; i<arr.length-k+1; i++){
            s-=arr[i-1];
            s+=arr[i+k-1];
            max=Math.max(max,s);
        }
        return max;
    }
}

// Python Code
def maxSubarraySum(self, arr, k):
        # code here 
        n = len(arr)
        
        s = sum(arr[:k])
        maxSum = s
        
        for i in range(k, n):
            s -= arr[i-k]
            s += arr[i]
            
            maxSum = max(maxSum, s)
            
        return maxSum
