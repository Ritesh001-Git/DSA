class Solution:
    def closedIsland(self, grid: list[list[int]]) -> int:
        n, m = len(grid), len(grid[0])

        def dfs(i, j):
            if i < 0 or i >= n or j < 0 or j >= m: return False

            if grid[i][j] == 1: return True

            grid[i][j] = 1

            down = dfs(i + 1, j)
            up = dfs(i - 1, j)
            right = dfs(i, j + 1)
            left = dfs(i, j - 1)

            return down and up and right and left

        c = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 0:
                    if dfs(i, j):
                        c += 1

        return c
