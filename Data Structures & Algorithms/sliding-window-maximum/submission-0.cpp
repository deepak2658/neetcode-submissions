class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        multiset<int>sett;
        int n = nums.size();
        for(int  i = 0 ; i < k ; i++) {
            sett.insert(nums[i]);
        }
        vector<int>ans(n-k+1);
        ans[0] = *(sett.rbegin());
        int j = k;
        while(j < nums.size()) {
            sett.erase(sett.lower_bound(nums[j - k]));
            sett.insert(nums[j]);
            ans[j-k+1] = *(sett.rbegin());
            j++;
        }
        return ans;
    }
};
