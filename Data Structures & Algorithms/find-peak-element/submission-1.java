class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left + (right -left)/2;

            // check for peak
            long leftValue = Long.MIN_VALUE;
            long rightValue =Long.MIN_VALUE;
            if(mid-1 >=0)
                leftValue = (long)nums[mid-1];
            if(mid+1 < nums.length)
                rightValue = (long)nums[mid+1];

            if(nums[mid] > leftValue && nums[mid] > rightValue)
                return mid;


            if(mid+1 < nums.length && nums[mid+1] >= nums[mid])
                left = mid+1;
            else if(mid-1 >=0 && nums[mid-1] >= nums[mid])
                right = mid-1;
            else{

            }
        }

        return left;
    }
}