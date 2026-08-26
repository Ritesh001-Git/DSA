# TC - O(n)

class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        count = 0
        j = 0
        ans = ""

        for i in range(len(s)):
            if s[i] == "1":
                count += 1

            while count > k:
                if s[j] == "1":
                    count -= 1
                j += 1

            if count == k:
                while j <= i and s[j] == '0' and count == k:
                    j += 1

                temp = s[j:i + 1]

                if (not ans or
                    len(temp) < len(ans) or
                    (len(temp) == len(ans) and temp < ans)):
                    ans = temp

        return ans
