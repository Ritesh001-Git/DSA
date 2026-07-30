# TC - O(n)
# SC - O(n)

class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums

        n = len(nums)
        self.res = [0] * n

        self.res[0] = nums[0]

        for i in range(1, n):
            self.res[i] = self.res[i-1] + nums[i]

    def sumRange(self, i, j):
        """
        :type left: int
        :type right: int
        :rtype: int
        """
        r = self.res[j] - self.res[i-1] if i > 0 else self.res[j]
        return r
        


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)
