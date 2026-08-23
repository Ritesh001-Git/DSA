# TC - O(n)
# SC - O(1)

class Solution:
    def sumGame(self, num: str) -> bool:
        n = len(num)

        leftSum = 0
        rightSum = 0
        
        leftQ = 0
        rightQ = 0

        for i in range(n):
            if num[i] == "?":
                if i < n // 2:
                    leftQ += 1
                else:
                    rightQ += 1
            else:
                if i < n // 2:
                    leftSum += int(num[i])
                else:
                    rightSum += int(num[i])

        totalQ = leftQ + rightQ
        if totalQ % 2 == 1: return True # If total Question Mark is odd then Alice Wins

        return 2 * leftSum + 9 * leftQ != 2 * rightSum + 9 * rightQ
