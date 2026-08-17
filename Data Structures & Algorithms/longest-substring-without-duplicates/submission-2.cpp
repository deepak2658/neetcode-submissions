class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int stringSize = s.length();
        if(stringSize == 0 || stringSize == 1) return stringSize;
        unordered_map<char, int>charMap;
        int left = 0;
        int right = 0;
        int ans = 1;
        while(right < stringSize) {
            if(charMap.find(s[right]) != charMap.end()) {
                if(charMap[s[right]] >= left) {
                    left = charMap[s[right]] + 1;
                }
                //cout << "left becomes = " << left << endl;
            }
            charMap[s[right]] = right;
            ans = max(ans, right - left + 1);
            //cout << "answer becomes = " << ans << endl;
            right++;
        }
        return ans;
    }
};
