class Solution {
public:
    int calculate(int n, vector<int>&coins, vector<int>&dp) {
        if(n < 0) return INT_MIN;
        if(n == 0) return 0;
        if(dp[n] != INT_MAX) return dp[n];
        for(int i = 0; i < coins.size(); i++) {
            if(coins[i] <= n) {
                dp[n] = min(dp[n], 1 + calculate(n - coins[i], coins, dp));
            } else break;
        }
        return dp[n];
    }
    int numSquares(int n) {
        int num = 1;
        vector<int>coins;
        while(num*num <= n) {
            coins.push_back(num*num);
            num++;
        } 
        //Now this is simple coin change problem.
        vector<int>dp(n+1, INT_MAX);
        return calculate(n, coins, dp);
    }
};