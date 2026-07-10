// class Solution {
    
//     public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
//     }
// }

import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // original index
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int LOG = 20;
        int[][] up = new int[n][LOG];

        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            while (arr[r][0] - arr[l][0] > maxDiff) {
                r--;
            }

            up[arr[l][1]][0] = arr[r][1];

            for (int k = 1; k < LOG; k++) {
                up[arr[l][1]][k] = up[up[arr[l][1]][k - 1]][k - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (nums[u] > nums[v]) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            if (nums[u] == nums[v]) {
                ans[i] = 1;
                continue;
            }

            int dist = 0;
            int cur = u;

            for (int k = LOG - 1; k >= 0; k--) {
                if (nums[up[cur][k]] < nums[v]) {
                    dist += 1 << k;
                    cur = up[cur][k];
                }
            }

            if (nums[up[cur][0]] < nums[v]) {
                ans[i] = -1;
            } else {
                ans[i] = dist + 1;
            }
        }

        return ans;
    }
}