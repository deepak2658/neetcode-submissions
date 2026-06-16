/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return true;
        Collections.sort(intervals,
         (a,b) -> Integer.compare(a.start,b.start));

        Interval prevInt = intervals.get(0);

        for( int i = 1; i < intervals.size(); i++){
            Interval currInt = intervals.get(i);

            if(currInt.start < prevInt.end)
                return false;
            
            prevInt.end = currInt.end;
        }

        return true;
    }
}
