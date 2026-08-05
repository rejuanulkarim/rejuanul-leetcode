class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // GRAPH 
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        //Degree
        int [] inDegree = new int [n];
        boolean[] suspicious = new boolean[n];

        for(int [] edge: invocations){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        //BFS
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(k);
        suspicious[k] = true;
        while(!q.isEmpty()){
            int curr = q.pollFirst();
            for(int ngbr: adj.get(curr)){
                inDegree[ngbr]--;
                if(!suspicious[ngbr]){
                    q.offerLast(ngbr);
                    suspicious[ngbr] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        boolean canNotRemove = false;
        for(int i=0;i<n;i++){
            if(suspicious[i] && inDegree[i] > 0){
                // we connot remove anything. Just return 0,1,2....n-1
                canNotRemove = true;
                break;
            }
            if(!suspicious[i]) list.add(i);
        }
        if(canNotRemove){
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<n;i++){
                res.add(i);
            }
            return res;
        }
        return list;
    }
}