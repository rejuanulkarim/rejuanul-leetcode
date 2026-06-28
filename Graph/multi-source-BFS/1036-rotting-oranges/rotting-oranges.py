class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row = len(grid)
        col = len(grid[0])
        count = 0
        q = []
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 2:
                    q.append((i,j))
                elif grid[i][j] == 1:
                    count+=1
        if count == 0: return 0 #if grid have no 1 than 0
        res = 0
        direct = [(1,0),(0,1),(-1,0),(0,-1)]

        while q and count:
            size = len(q)

            for e in range(size):
                x,y = q.pop(0)
                
                for dr , dc in direct:
                    r = x+dr
                    c = y+dc

                    if 0<= r <row and 0<= c <col  and grid[r][c] == 1:
                        count -=1
                        q.append((r,c))
                        grid[r][c] = 2
            res +=1



        return res if (count == 0) else -1      


