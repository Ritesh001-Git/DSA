# TC - O(n)
# SC - O(n)

class Solution:
    def maxSumWithK(self, arr: list[int], k: int) -> int:
        # code here
        n = len(arr)
        
        bestEnd = [0]*n
        bestEnd[0] = arr[0]
        for i in range(1,n):
            bestEnd[i] = max(arr[i],arr[i]+bestEnd[i-1])
        
        winsum = sum(arr[:k])
        ans = winsum
        
        for i in range(k,n):
            winsum = winsum + arr[i] - arr[i-k]
            ans = max(ans,winsum+bestEnd[i-k],winsum)
        return ans
        
