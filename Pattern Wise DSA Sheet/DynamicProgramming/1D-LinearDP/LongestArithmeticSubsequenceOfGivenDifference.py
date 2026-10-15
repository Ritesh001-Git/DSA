# Approach-1 (Recursion + Memo with 2-D Memo) MLE

from functools import lru_cache
class Solution:
    def longestSubsequence(self, arr: list[int], difference: int) -> int:
        n = len(arr)

        @lru_cache(None)
        def solve(idx, prev):
            if idx >= n: return 0

            take = 0
            if prev == float('-inf') or arr[idx] - prev == difference:
                take = 1 + solve(idx + 1, arr[idx])

            skip = solve(idx + 1, prev)
            
            return max(take, skip)

        return solve(0, float('-inf'))

# Approach-2 (Using Map) - O(n) - Accepted

class Solution:
    def longestSubsequence(self, arr: list[int], difference: int) -> int:
        n = len(arr)

        mp = {}

        m = 0

        for i in range(n):
            prev = arr[i] - difference
            if prev in mp:
                mp[arr[i]] = mp[prev] + 1
            else:
                mp[arr[i]] = 1
            
            m = max(mp[arr[i]], m)

        return m
