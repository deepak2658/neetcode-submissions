class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1 && k==1)
            return nums[0];
    
        int n = nums.length;
        int[] pref = new int[n+1];
        int sum = 0;
        int idx = 0;
        pref[idx++] = 0;

        for(int num: nums){
            sum+= num;
            pref[idx++] = sum;
        }

        double maxAvg = Double.MIN_VALUE;

        for(int size = k; size <=n; size++){
            for(int right = size-1; right < n; right++){
                int left = right-size+1;
                // System.out.println(left + " " + right);
                double avg =  (double)(pref[right+1] - (pref[left]))/ (double) (size);

                maxAvg = Math.max(maxAvg, avg);
            }
        }

        return maxAvg;
    }
}
