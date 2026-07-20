class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        k = k%(row*col);

        int [][] res = new int[row][col];
        
        int r = k/col, c = k%col;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(c == col){
                    c = 0;
                    r++;
                }
                if(r == row) r=0;
                res[r][c] = grid[i][j];
                c++;
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<row;i++){
            List<Integer> curr = new ArrayList<>();
            for(int j =0;j<col;j++){
                curr.add(res[i][j]);
            }
            list.add(curr);
        }
        return list;
    }

}