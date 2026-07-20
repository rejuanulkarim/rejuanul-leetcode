class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        row = len(grid); col = len(grid[0])
        total = row*col
        res = [[0]*col for _ in range(row)]
        k= k%total
        for i in range(row):
            for j in range(col):
                r = k//col
                c = k%col
                k = (k+1)%total
                res[r][c] = grid[i][j]
        return res
