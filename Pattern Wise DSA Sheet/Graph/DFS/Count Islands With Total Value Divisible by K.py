class Solution:
    def countIslands(self, grid: List[List[int]], k: int) -> int:
        n, m = len(grid), len(grid[0])

        def dfs(i, j):
            if i >= n or j >= m or i < 0 or j < 0:
                return 0

            if grid[i][j] == 0: return 0

            s = grid[i][j]
            grid[i][j] = 0

            s += dfs(i + 1, j)
            s += dfs(i - 1, j)
            s += dfs(i, j + 1)
            s += dfs(i, j - 1)

            return s

        c = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] != 0:
                    if dfs(i, j) % k == 0:
                        c += 1

        return c

