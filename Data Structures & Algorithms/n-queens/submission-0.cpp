class Solution {
public:
    bool isValid(int row, int col, vector<string>sol, int n) {
        if(row >= n || col >= n) return false;
        for(int i = 0; i < n; i++) {
            if(sol[row][i] == 'Q' || sol[i][col] == 'Q') return false;
        }
        int i = row; int j = col;
        while(i >= 0 && j >= 0) {
            if(sol[i][j] == 'Q') return false;
            i--; j--;
        }
        i = row; j = col;
        while(i < n && j < n) {
            if(sol[i][j] == 'Q') return false;
            i++; j++;
        }
        i = row; j = col;
        while(i >= 0 && j >= 0 && i < n && j < n) {
            if(sol[i][j] == 'Q') return false;
            i++; j--;
        }
        i = row; j = col;
        while(i >= 0 && j >= 0 && i < n && j < n) {
            if(sol[i][j] == 'Q') return false;
            i--; j++;
        }
        return true;
    }
    void solve(int row, vector<vector<string>>&ans, vector<string>&sol, int n) {
        if(row == n) {
            ans.push_back(sol);
            return;
        }
        for(int col = 0; col < n; col++) {
            if(isValid(row, col, sol, n)) {
                sol[row][col] = 'Q';
                solve(row+1, ans, sol, n);
                sol[row][col] = '.';
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>>ans;
        vector<string>sol(n, string(n, '.'));
        solve(0, ans, sol,n);
        return ans;
    }
};
