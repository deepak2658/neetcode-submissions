class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Integer.MIN_VALUE;

        // FIX: minPile was unnecessary, removed it
        for(int pile: piles){
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1;          // FIX: binary search lower bound
        int right = maxPile;   // FIX: binary search upper bound
        int res = maxPile;     // FIX: initialize with worst case speed

        // FIX: replace linear scan with binary search
        while(left <= right){

            int mid = left + (right - left) / 2;

            int currHours = totalHoursNeeded(piles, mid);

            if(currHours <= h){
                res = mid;          // FIX: store possible answer
                right = mid - 1;    // FIX: try smaller speed
            } else {
                left = mid + 1;     // FIX: need faster speed
            }
        }

        return res;
    }

    int totalHoursNeeded(int[] piles, int speed){
        int totalTimeConsumed = 0;

        for(int pile: piles){

            // FIX: use ceiling division instead of manual mod logic
            totalTimeConsumed += (pile + speed - 1) / speed;

        }

        return totalTimeConsumed;
    }
}