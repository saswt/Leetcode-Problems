class Solution {

    int[][] memo;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        memo = new int[n][n + 1];

        return dfs(0, 1);
    }

    private int dfs(int i, int M) {

        if (i >= n)
            return 0;

        if (i + 2 * M >= n)
            return suffix[i];

        if (memo[i][M] != 0)
            return memo[i][M];

        int ans = 0;

        for (int X = 1; X <= 2 * M; X++) {
            ans = Math.max(ans,
                    suffix[i] - dfs(i + X, Math.max(M, X)));
        }

        memo[i][M] = ans;
        return ans;
    }
}