/*
class Solution {
    int result = Integer.MAX_VALUE;
    HashMap<Integer, List< int[] >> adj;
    boolean [] visited ;

    public int minScore(int n, int[][] roads) {
        adj = new HashMap<>();
        visited = new boolean[n+1];
        for(int [] vec: roads){
            int u = vec[0];
            int v = vec[1];
            int d = vec[2];
            adj.computeIfAbsent(u,k-> new ArrayList<>()).add(new int[]{v,d});
            adj.computeIfAbsent(v,k-> new ArrayList<>()).add(new int[]{u,d});
        }
        dfs(1);
        return result;
    }
    void dfs(int u){
        visited[u] = true;
        //neighbor
        for(int [] arr : adj.get(u)){
            int v = arr[0];
            int d = arr[1];
            result = Math.min(result, d);
            if(!visited[v]){
                dfs(v);
            }
        }
    }
}
*/

class Solution {
    int result = Integer.MAX_VALUE;
    List<List< int[] >> adj;
    boolean [] visited ;

    public int minScore(int n, int[][] roads) {
        adj = new ArrayList<>();
        visited = new boolean[n+1];
        // create n+1 empty lists
        for(int i=0; i<=n;i++){
            adj.add(new ArrayList<>());
        }
        // create graph
        for(int[] road:roads){
            int u = road[0];
            int v = road[1];
            int d = road[2];
            adj.get(u).add(new int[]{v,d});
            adj.get(v).add(new int[]{u,d});
        }
        dfs(1);
        return result;
    }
    void dfs(int u){
        visited[u] = true;
        for(int[] edge: adj.get(u)){
            int v = edge[0];
            int d = edge[1];
            result = Math.min(result,d);
            if(!visited[v]){
                dfs(v);
            }
        }
    }
}