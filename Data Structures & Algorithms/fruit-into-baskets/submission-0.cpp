class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int n = fruits.size();
        if(n == 1 || n == 2) return n;
        int left = 0;
        int right = 1;
        int ans = INT_MIN;
        while(right < n && fruits[left] == fruits[right]) {
            right++;
        }
        if(right >= n) return n;
        int fLast = right-1;
        int sLast = right;
        int ff = fruits[left];
        int sf = fruits[right];
        while(right < n && left < right) {
            while(right < n && (fruits[right] == ff || fruits[right] == sf)) {
                if(fruits[right] == ff) fLast = right;
                else sLast = right;
                right++;
            }
            ans = max(ans, right - left);
            if(right < n) {
                if(fLast < sLast) {
                    ff = sf;
                    left = fLast+1;
                    fLast = sLast;
                } else left = sLast+1;
                sf = fruits[right];
                sLast = right;
            }
        }
        return ans;
    }
};