class Solution:
    def countSubarray(self, arr: list[int], l: int, r: int) -> int:
        # code here
        n = len(arr)
        
        def solve(k):
            c = 0
            curr = 0
            j = 0
            
            for i in range(n):
                curr += arr[i]
                
                while curr > k:
                    curr -= arr[j]
                    j += 1
                    
                c += (i - j + 1)
                
            return c
                
        return solve(r) - solve(l-1)
