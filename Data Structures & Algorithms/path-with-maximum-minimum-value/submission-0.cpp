class Solution {
public:
    int maximumMinimumPath(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        priority_queue<pair<int, pair<int, int>>>pq;
        pq.push({grid[0][0], {0, 0}});
        int ans = grid[0][0];
        vector<vector<bool>>vis(n, vector<bool>(m, false));
        vis[0][0] = true;
        while(!pq.empty()) {
            int currVal = pq.top().first;
            int i = pq.top().second.first;
            int j = pq.top().second.second;
            ans = min(ans, currVal);
            pq.pop();
            if(i == n-1 && j == m-1) break; //Most crucial
            if(i > 0 && !vis[i-1][j]) {
                pq.push({grid[i-1][j], {i-1, j}});
                vis[i-1][j] = true;
            }
            if(j > 0 && !vis[i][j-1]) {
                pq.push({grid[i][j-1], {i, j-1}});
                vis[i][j-1] = true;
            }
            if(i < n-1 && !vis[i+1][j]) {
                pq.push({grid[i+1][j], {i+1, j}});
                vis[i+1][j] = true;
            }
            if(j < m-1 && !vis[i][j+1]) {
                pq.push({grid[i][j+1], {i, j+1}});
                vis[i][j+1] = true;
            }
        }
        return ans;
    }
};
