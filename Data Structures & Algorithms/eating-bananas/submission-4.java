class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = Integer.MIN_VALUE;

        // FIX: removed unused minPile
        for(int pile : piles){
            maxPile = Math.max(maxPile, pile);
        }

        int res = maxPile;

        for(int i = 1; i <= maxPile; i++){

            long currHours = totalHoursNeeded(piles, i); // FIX: use long

            if(currHours <= h){
                res = i;
                break; // smallest valid speed found
            }
        }

        return res;
    }

    long totalHoursNeeded(int[] piles, int speed){  // FIX: return long

        long totalTimeConsumed = 0; // FIX: prevent overflow

        for(int pile : piles){
            totalTimeConsumed += (pile + speed - 1) / speed; // ceil division
        }

        return totalTimeConsumed;
    }
}