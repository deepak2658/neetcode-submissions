class Solution {
    /*
        ____________
        days : max days to ship

        weights: weights[i] -> weight of ith package

        let k = weight capacity;

        right = sum;
        left = 1;

        left -> right loop while checking and if days(curr) <= days : return curr;

        BS on answer.

        //
        state : right, left, ans, isPossible(), min = k (max weight capacity);

        invariant :
            totalWt <= k;

        transition:
            bs transition
                if(true) left = mif-1;
                else right =mid+1;

                // days calc logic.

        goal : ans;

    */ 
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int weight: weights){
            left = Math.max(left, weight);
            right+=weight;
        }
        left = 1;
        int ans = right;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(ispossible(mid, weights, days)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return ans;
    }

    public boolean ispossible(int mid, int[] weights, int days){
        int currWt = 0;
        int count = 0;

        for(int weight: weights){
            if (weight > mid)
            return false;
            currWt += weight;
            if(currWt > mid){
                count++;
                currWt = weight;
            }
        }

        if(currWt > 0)
            count++;

        return count <= days;
    }
}