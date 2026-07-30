# TC - O(n^2)
# TC - O(n^2)

class NumMatrix(object):
    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        self.mat = matrix
        n, m = len(self.mat), len(self.mat[0])
        self.preSum = [[0] * (m+1) for _ in range(n+1)]

        for i in range(1, n+1):
            for j in range(1, m+1):
                self.preSum[i][j] = self.mat[i-1][j-1] + self.preSum[i-1][j] + self.preSum[i][j-1] - self.preSum[i-1][j-1]

    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """

        res = self.preSum[row2+1][col2+1] - self.preSum[row1][col2+1] - self.preSum[row2+1][col1] + self.preSum[row1][col1]
        return res
        


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)
