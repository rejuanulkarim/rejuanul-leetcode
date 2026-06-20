class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        int [][] arr = new int[m+2][2];
        for(int i =0;i<m;i++){
            arr[i] = restrictions[i];
        }
        arr[m] = new int[]{1,0};
        arr[m+1] = new int[]{n,n-1};

        Arrays.sort(arr,(a,b)-> Integer.compare(a[0],b[0]));

        for(int i=1;i<m+2;i++){
            arr[i][1] = Math.min(arr[i][1],arr[i][0]-arr[i-1][0]+arr[i-1][1]);
        }
        for(int i=m;i>=0;i--){
            arr[i][1] = Math.min(arr[i][1], arr[i+1][0]-arr[i][0] + arr[i+1][1]);
        }
        int max =0;
        for(int i=1;i<m+2;i++){
            int peek = arr[i-1][1]+(arr[i][0] - arr[i-1][0]+arr[i][1] - arr[i-1][1])/2;
            max =Math.max(max,peek);
        }
        return max;
    }
}