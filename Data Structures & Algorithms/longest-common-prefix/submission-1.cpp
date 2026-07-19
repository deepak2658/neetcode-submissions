class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        for(int i = 1; i< strs.size();i++) {
            for(int j = 0; j<strs[0].length(); j++) {
                if(strs[0][j] != strs[i][j]) {
                    strs[0] = strs[0].substr(0, j);
                    break;
                }
            }
        }
        return strs[0];
    }
};