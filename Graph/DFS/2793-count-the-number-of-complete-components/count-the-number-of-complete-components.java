class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v =edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int res =0;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            int[] vtx = new int[1];
            int[] edg = new int[1];

            dfs(i,adj,visited,vtx,edg);
            if((vtx[0]*(vtx[0]-1)) == edg[0]){
                res++;
            }
        }
        return res;
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited, int[] vtx, int[] edg) {

        visited[node] = true;
        vtx[0]++;
        edg[0] += adj.get(node).size();

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(nei, adj, visited, vtx, edg);
            }
        }
    }

}