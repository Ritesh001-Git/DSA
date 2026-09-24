from collections import Counter
class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        if len(s) < k:
            return 0

        mp = Counter(s)

        for idx, ele in enumerate(s):
            if mp[ele] < k:
                return max(
                    self.longestSubstring(s[:idx], k),
                    self.longestSubstring(s[idx + 1:], k)
                )

        return len(s)
