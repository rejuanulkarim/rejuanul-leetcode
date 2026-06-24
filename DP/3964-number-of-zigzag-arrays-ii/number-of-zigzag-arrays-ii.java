class Solution {

    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int M = r - l + 1;

        if (n == 1) return M;

        int S = 2 * M;

        long[][] trans = new long[S][S];

        // down(v) = v
        // up(v)   = M + v

        for (int cur = 0; cur < M; cur++) {

            // down(cur) -> up(next), next > cur
            for (int nxt = cur + 1; nxt < M; nxt++) {
                trans[M + nxt][cur] = 1;
            }

            // up(cur) -> down(next), next < cur
            for (int nxt = 0; nxt < cur; nxt++) {
                trans[nxt][M + cur] = 1;
            }
        }

        long[] base = new long[S];

        // arrays of length 2
        for (int a = 0; a < M; a++) {
            for (int b = 0; b < M; b++) {

                if (a == b) continue;

                if (a < b) {
                    base[M + b]++;
                } else {
                    base[b]++;
                }
            }
        }

        long[][] power = matrixPower(trans, n - 2);

        long[] resultVector = multiply(power, base);

        long ans = 0;
        for (long x : resultVector) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] mat, long[] vec) {

        int n = mat.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {

            long sum = 0;

            for (int j = 0; j < n; j++) {
                sum = (sum + mat[i][j] * vec[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }

    private long[][] matrixPower(long[][] mat, long exp) {

        int n = mat.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {

            if ((exp & 1) == 1) {
                res = multiply(res, mat);
            }

            mat = multiply(mat, mat);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {

        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {

            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }
}