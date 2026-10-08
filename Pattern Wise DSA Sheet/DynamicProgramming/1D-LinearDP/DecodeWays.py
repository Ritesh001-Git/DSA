# Approach 1: Top-Down (Memoization)

class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        dp = [-1] * len(s)

        def solve(idx):
            if idx >= len(s): return 1
            if s[idx] == "0": return 0

            if dp[idx] != -1: return dp[idx]

            take_one = solve(idx+1)

            take_two = 0
            if idx + 1 < len(s):
                num = int(s[idx]) * 10 + int(s[idx + 1])
                if num <= 26: take_two = solve(idx+2)

            dp[idx] = take_one + take_two
            return dp[idx]

        return solve(0)



# Approach 2: Bottom-Up (Tabulation)

class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dp = [0] * (n+1)

        dp[n] = 1

        for i in range(n-1,-1,-1):
            if s[i] == "0":
                dp[i] = 0
                continue

            # Take one
            dp[i] = dp[i + 1]

            # Take Two
            if i + 1 < n:
                num = int(s[i]) * 10 + int(s[i + 1])
                if num <= 26: dp[i] += dp[i + 2]

        return dp[0]

        
