class Solution {
public:
    vector<int> timeTaken(vector<int>& arrival, vector<int>& state) {
        int n = arrival.size();
        int idolTime = 0;
        int lastUsed = -1;
        priority_queue<int, vector<int>, greater<int>>enterQ;
        priority_queue<int, vector<int>, greater<int>>exitQ;
        int j = 0;
        vector<int>ans(n, -1);
        for(int i = 0; i <= max(arrival[n-1], idolTime); i++) {
            while(j < n && arrival[j] == i) {
                if(state[j] == 0) enterQ.push(j);
                else exitQ.push(j);
                j++;
            }
            if(i >= idolTime) {
                if(enterQ.empty() && exitQ.empty()) { // if none available
                    lastUsed = -1;
                    continue;
                }
                if((lastUsed == 1 || lastUsed == -1 || enterQ.empty()) && !exitQ.empty()) {
                    ans[exitQ.top()] = i;
                    exitQ.pop();
                    idolTime = i+1;
                    lastUsed = 1;
                } else if(!enterQ.empty()) {
                    ans[enterQ.top()] = i;
                    enterQ.pop();
                    idolTime = i+1;
                    lastUsed = 0;
                } else {
                    lastUsed = -1;
                }
            }
        }
        return ans;
    }
};
