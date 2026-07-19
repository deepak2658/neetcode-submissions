class Solution {
public:
    int minNumberOperations(vector<int>& target) {
        queue<pair<int, int>>indexPairs;
        indexPairs.push({0, target.size()-1});
        int ans = 0;
        while(!indexPairs.empty()) {
            pair<int, int>curr = indexPairs.front();
            indexPairs.pop();
            if(curr.first == curr.second) {
                ans+=target[curr.first];
                continue;
            }
            int i = curr.first;
            while(i <= curr.second) {
                target[i]--;
                if (target[i] == 0) {
                    if(curr.first < i-1) {
                        indexPairs.push({curr.first, i-1});
                    } else if (curr.first == i-1) ans += target[i-1];
                    curr.first = i+1;
                }
                i++;
            }
            ans++;
            if(curr.first < curr.second) {
                indexPairs.push({curr.first, curr.second});
            } else if(curr.first == curr.second) ans += target[curr.first];
        }   
        return ans;
    }
};