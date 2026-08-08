class Solution {
    int[][] dp;

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int n = envelopes.length;

        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return findDolls(envelopes, 0, -1);
    }

    public int findDolls(int[][] envelopes, int idx, int prevIdx) {

        if (idx == envelopes.length)
            return 0;

        if (dp[idx][prevIdx + 1] != -1)
            return dp[idx][prevIdx + 1];

        int op1 = findDolls(envelopes, idx + 1, prevIdx);

        int op2 = 0;

        if (prevIdx == -1 ||
            (envelopes[idx][0] > envelopes[prevIdx][0] &&
             envelopes[idx][1] > envelopes[prevIdx][1])) {

            op2 = 1 + findDolls(envelopes, idx + 1, idx);
        }

        return dp[idx][prevIdx + 1] = Math.max(op1, op2);
    }
}