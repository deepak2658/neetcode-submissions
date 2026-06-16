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
    public int minMeetingRooms(List<Interval> intervals) {
        int[] startArr = new int[intervals.size()];
        int[] endArr = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            startArr[i] = curr.start;
            endArr[i] = curr.end;
        }

        Arrays.sort(startArr);
        Arrays.sort(endArr);

        int count = 0;
        int max = 0;

        int i = 0;
        int j = 0;

        while( i < startArr.length && j < endArr.length){
            if(startArr[i] < endArr[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
