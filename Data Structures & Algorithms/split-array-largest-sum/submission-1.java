class Solution {
    int res = Integer.MAX_VALUE;
    int[] pref;
    int[][] dp;
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        pref = new int[n+1];
        dp = new int[n+1][k+1];
        for(int i = 0; i < n+1; i++)
            Arrays.fill(dp[i], -1);

        int sum = 0;

        for(int i = 0; i < n; i++){
            sum+= nums[i];
            pref[i+1] = sum;
        }

        return backtrack(nums, 0, k, new ArrayList<>());
        // return res;
    }

    public int backtrack(int[] nums, int idx, int k, List<Integer> path){
        if (k == 1) {
            return pref[nums.length] - pref[idx];
        }
        
        // We must have enough elements left for k subarrays
        if (nums.length - idx < k) {
            return Integer.MAX_VALUE / 2;
        }

        if(dp[idx][k] != -1)
            return dp[idx][k];

        int min  = 100000003;
        for(int i = idx; i < nums.length; i++){
            int curr = pref[i+1] - pref[idx];
            int next = 0;
            next = backtrack(nums, i+1, k-1, path);

            min = Math.min(min, Math.max(curr, next));
        }

        return dp[idx][k] = min;
    }
}