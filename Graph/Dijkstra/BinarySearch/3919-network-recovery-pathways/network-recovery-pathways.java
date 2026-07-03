
class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int low = 0;
        int high = 0;

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            high = Math.max(high, e[2]);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid, graph, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int minCost,
                          List<List<int[]>> graph,
                          boolean[] online,
                          long k,
                          int n) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            int node = (int) cur[0];
            long cost = cur[1];

            if (cost > dist[node])
                continue;

            if (node == n - 1)
                return true;

            for (int[] edge : graph.get(node)) {

                int next = edge[0];
                int wt = edge[1];

                if (wt < minCost)
                    continue;

                if (next != n - 1 && !online[next])
                    continue;

                long newCost = cost + wt;

                if (newCost <= k && newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.offer(new long[]{next, newCost});
                }
            }
        }

        return false;
    }
}