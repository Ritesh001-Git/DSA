# TC - O(n)
# SC - O(n)

class Solution:
    def rangeSumQueries(self, arr, queries):
        # code here
        n = len(arr)
        res = [0] * n

        res[0] = arr[0]

        for i in range(1, n):
            res[i] = res[i-1] + arr[i]
        
        a = []
        
        for i,j in queries:
            r = res[j] - res[i-1] if i > 0 else res[j]
            a.append(r)
            
        return a
