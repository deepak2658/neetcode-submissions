class Solution {
    /*
        piles[n]: piles[i] -> no of bananas at i
        h -> no of hours
        k -> best optimized speed.

        return k so that all bananas are finished in h hours
        brute force:
            i : 0-> max(piles)
            if(k <= h)
                continue;
            else
                return k;

        BS on answer;

        [1,2,3,.... max]
        [f,f,f,...p,p,p,....p];

        i have to return first pass;

        contract:
            state: lo = 1, hi = max(nums[i]); ans <- min speed.

        invariant: lo < high
        transition: 
            if(condition) high = mid-1;
            else    lo = mid+1;

        goal min k
        edge: n = 0 
        |
         h < n

    */
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;

        for(int pile: piles)
            hi = Math.max(hi, pile);

        int ans = hi;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(isPossible(mid, piles, h)){
                ans = mid;
                hi = mid-1;
            }
            else
                lo = mid+1;
        }

        return ans;
    }

    public boolean isPossible(int speed, int[] piles, int h){
        long tt = 0;

        for(int pile: piles){
            tt += (pile%speed == 0 ? (long)pile/speed : (long)(pile/speed+1));
        }

        if(tt <= h)
            return true;
        else
            return false;
    } 
}
