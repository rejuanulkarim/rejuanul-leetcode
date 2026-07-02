class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
       int m = grid.size(), n = grid.get(0).size();
       int[][] result = new int[m][n];
        for(int[] arr: result){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
       Deque<Pair> q = new ArrayDeque<>();
       result[0][0] = grid.get(0).get(0);
       q.offerFirst(new Pair(0,0));
       while(!q.isEmpty()){
        Pair pair = q.removeFirst();
        int r = pair.row, c = pair.col;
        for( int [] dir: direction){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr<0 || nr>=m || nc<0 || nc>=n) continue;
            if(result[r][c] + grid.get(nr).get(nc) < result[nr][nc]){
                result[nr][nc] = result[r][c] + grid.get(nr).get(nc);

                if(grid.get(nr).get(nc)== 0){
                    q.offerFirst(new Pair(nr,nc));
                }else{
                    q.offerLast(new Pair(nr,nc));
                }
            }
        }
       }

       return health - result[m-1][n-1] >= 1;
    }
}