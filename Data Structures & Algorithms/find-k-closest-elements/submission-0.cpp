class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        if(k == n) return arr;
        int sumOfDiff = 0;
        for(int i = 0; i < k; i++) {
            sumOfDiff += abs(x-arr[i]);
        }
        int l = 1;
        int r = k;
        int finalL = 0;
        int finalR = k-1;
        while(r < n) {
            int sumDiff2 = sumOfDiff-abs(x-arr[l-1])+abs(x-arr[r]);
            if(sumDiff2 > sumOfDiff) {
                break;
            }
            if (sumDiff2 < sumOfDiff) {
                finalL = l;
                finalR = r;
                sumOfDiff = sumDiff2;
            }
            l++;
            r++;
        }
        vector<int>ans(arr.begin()+finalL, arr.begin()+finalR+1);
        return ans;
    }
};