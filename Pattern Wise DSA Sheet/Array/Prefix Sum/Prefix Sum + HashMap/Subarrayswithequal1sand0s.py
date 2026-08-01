# TC - O(n)
# SC - O(n)

class Solution:
    def countSubarray(self, arr):
        # code here
        
        mp = {0:1}
        
        c = ans = 0
        
        for i in range(len(arr)):
            c += (1 if arr[i] == 1 else -1)
            
            if c in mp:
                ans += mp[c]
            
            mp[c] = mp.get(c, 0) + 1 
            
        return ans
