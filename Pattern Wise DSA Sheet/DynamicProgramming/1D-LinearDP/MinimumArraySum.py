# Approach - Trying all possibilities (Recursion + Memoization)
# T.C : O(n*op1*op2)
# S.C : O(n*op1*op2)

class Solution:
    def minArraySum(self, nums: List[int], k: int, op1: int, op2: int) -> int:
        from functools import lru_cache

        n = len(nums)

        @lru_cache(None)
        def solve(idx, o1, o2):
            if idx >= n: return 0

            res = float('inf')
            
            # op1
            if o1 > 0:
                val = (nums[idx] + 1 ) // 2
                curr = val + solve(idx + 1, o1 - 1, o2)
                res = min(res, curr)

            # op2
            if o2 > 0 and nums[idx] >= k:
                val = nums[idx] - k
                curr = val + solve(idx + 1, o1, o2 - 1)
                res = min(res, curr)

            # Both
            if o1 > 0 and o2 > 0:
                # op1 -> op2
                val = (nums[idx] + 1) // 2
                if val >= k:
                    val = val - k
                    curr = val + solve(idx + 1,o1 - 1, o2 - 1)
                    res = min(res, curr)

                # op2 -> op1
                if nums[idx] >= k:
                    val = nums[idx] - k
                    val = (val + 1) // 2
                    curr = val + solve(idx + 1,o1 - 1, o2 - 1)
                    res = min(curr, res)
            
            # No operation
            res = min(res, nums[idx] + solve(idx + 1 ,o1 ,o2))

            return res

        return solve(0, op1, op2)
