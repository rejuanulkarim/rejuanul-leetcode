class Solution {

    class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int n;
    int [][] dist;

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) return 0;
        // Distance from nearest thief
        dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<Pair> q = new LinkedList<>();

        // Multi-source BFS initialization
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    dist[r][c] = 0;
                    q.offer(new Pair(r, c));
                }
            }
        }

        // Multi-source BFS
        while (!q.isEmpty()) {

            Pair cur = q.poll();

            for (int[] d : dir) {

                int nr = cur.row + d[0];
                int nc = cur.col + d[1];

                if (isValid(nr, nc) && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur.row][cur.col] + 1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        int left = 0;
        int right = 2 * n;
        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isSafe(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    boolean isSafe(int safe) {

        if (dist[0][0] < safe)
            return false;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.offer(new Pair(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            if (cur.row == n - 1 && cur.col == n - 1)
                return true;

            for (int[] d : dir) {

                int nr = cur.row + d[0];
                int nc = cur.col + d[1];

                if (isValid(nr, nc)
                        && !visited[nr][nc]
                        && dist[nr][nc] >= safe) {

                    visited[nr][nc] = true;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        return false;
    }

    boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}