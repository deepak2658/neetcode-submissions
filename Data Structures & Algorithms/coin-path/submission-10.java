class Solution {

    public List<Integer> cheapestJump(int[] coins, int maxJump) {

        int n = coins.length;

        List<Integer> ans = new ArrayList<>();

        if (coins[0] == -1 || coins[n - 1] == -1)
            return ans;

        long INF = Long.MAX_VALUE / 4;

        long[] dp = new long[n];
        int[] next = new int[n];

        Arrays.fill(dp, INF);
        Arrays.fill(next, -1);

        dp[n - 1] = coins[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            if (coins[i] == -1)
                continue;

            for (int j = i + 1;
                 j <= Math.min(n - 1, i + maxJump);
                 j++) {

                if (dp[j] == INF)
                    continue;

                long cost = coins[i] + dp[j];

                if (cost < dp[i]) {

                    dp[i] = cost;
                    next[i] = j;

                } else if (cost == dp[i]) {

                    // Lexicographically smaller path
                    if (next[i] == -1 || j < next[i])
                        next[i] = j;
                }
            }
        }

        if (dp[0] == INF)
            return ans;

        int curr = 0;

        while (curr != -1) {
            ans.add(curr + 1);
            curr = next[curr];
        }

        return ans;
    }
}