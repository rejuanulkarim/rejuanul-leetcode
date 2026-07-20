/*
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
*/

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int []arr;
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int total = row*col;
        arr = new int[total];
        k = k%total;
        int idx = 0;
        for(int i =row-1;i>=0;i--){
            for(int j=col-1; j>=0;j--){
                arr[idx++] = grid[i][j];
            }
        }
        reverse(arr,0,k-1);
        reverse(arr,k,total-1);
        makeList(arr,row,col);
        return list;
    }
    private void reverse(int []arr,int s, int e){
        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;e--;
        }
    }
    private void makeList(int []arr,int row,int col){
        int idx = 0;
        for(int i=0;i<row;i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<col;j++){
                curr.add(arr[idx++]);
            }
            list.add(curr);
        }
    }
}