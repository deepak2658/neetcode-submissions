/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int left = 0;
        int right = n-1;
        int peak = -1;

        while(left <= right){
            int mid = left + (right-left)/2;

            int midVal = mountainArr.get(mid);

            int leftVal = Integer.MIN_VALUE;
            int rightVal = Integer.MIN_VALUE;

            if(mid > 0)
                leftVal = mountainArr.get(mid-1);
            if(mid <n-1)
                rightVal = mountainArr.get(mid+1);

            if(midVal > leftVal && midVal > rightVal){
                peak = mid;
                break;
            }
            else if(midVal < leftVal)
                right = mid-1;
            else
                left = mid+1;
        }

        if(mountainArr.get(peak) < target)
            return -1;

        int ans = findInLeft(target, peak, mountainArr);
        if(ans!=-1)
            return ans;
        ans = findInRight(target, left, n, mountainArr);
        return ans;
    }

    public int findInLeft(int target, int right, MountainArray mountainArr){
        int left = 0;
        while(left <= right){
            int mid = left + (right-left)/2;

            int midVal = mountainArr.get(mid);

            if(midVal == target)
                return mid;
            else if(midVal > target)
                right = mid-1;
            else
                left =mid+1;
        }

        return -1;
    }

    public int findInRight(int target, int left, int n, MountainArray mountainArr){
        int right = n-1;

        while(left <= right){
            int mid = left + (right-left)/2;

            int midVal = mountainArr.get(mid);

            if(midVal == target)
                return mid;
            else if(midVal < target)
                right = mid-1;
            else
                left =mid+1;
        }

        return -1;
    }
}