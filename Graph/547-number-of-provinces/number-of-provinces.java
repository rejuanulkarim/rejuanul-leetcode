class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean [] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,visited,i);
                count++;
            } 
        }
        return count;
    }
    private void dfs(int[][] graph,boolean[] visited, int city){
        if(visited[city]) return ; // if node is visited return.
        visited[city] = true; // mark node as visited.
        for(int j =0;j<graph.length;j++){
            if((graph[city][j] == 1) && (city != j)){ // (city != j) skip self edge
                dfs(graph,visited,j); // call dfs if node is conected.
            }
        }
    }
}