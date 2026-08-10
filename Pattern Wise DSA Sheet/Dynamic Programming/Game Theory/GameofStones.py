from functools import cache
class Solution:
    def stoneGame(self, n):
        # code here
        
        @cache
        def solve(curr):
            if curr <= 0: return False
            
            if curr >= 1:
                ans_1 = solve(curr-1)
                if not ans_1:
                    return True
            
            if curr >= 3:
                ans_3 = solve(curr-3)
                if not ans_3:
                    return True
            
            if curr >= 4:
                ans_4 = solve(curr-4)
                if not ans_4:
                    return True
                
            return False
            
        return solve(n)



class Solution:
    def stoneGame(self, n):
        # code here
        return n % 7 not in (0, 2)
