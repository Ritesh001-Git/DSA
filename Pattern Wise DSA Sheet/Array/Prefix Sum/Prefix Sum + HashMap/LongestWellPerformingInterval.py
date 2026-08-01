# TC - O(n)
# SC - O(n)

class Solution(object):
    def longestWPI(self, hours):
        """
        :type hours: List[int]
        :rtype: int
        """
        mp = {0:-1}
        sum = 0
        ans = 0

        for i in range(len(hours)):
            if hours[i] > 8: sum += 1
            else: sum -= 1

            if sum > 0:
                ans = i + 1
            else:
                if sum - 1 in mp:
                    ans = max(ans, i - mp[sum - 1])

            if sum not in mp:
                mp[sum] = i
        
        return ans
