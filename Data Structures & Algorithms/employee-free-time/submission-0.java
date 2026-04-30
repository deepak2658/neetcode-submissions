/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval a, Interval b){
            return Integer.compare(a.start, b.start);
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> combinedTime = new ArrayList<>();

        for(List<Interval> employee: schedule){
            for(Interval sch: employee){
                combinedTime.add(sch);
            }
        }

        List<Interval> res = new ArrayList<>();
        combinedTime.sort(new IntervalComparator());

        // for(Interval interval: combinedTime)
        //     System.out.println(interval.start + " " + interval.end);
        Interval prevInt = combinedTime.get(0);

        for(int i =1; i < combinedTime.size(); i++){
            Interval currInt = combinedTime.get(i);

            if(prevInt.end >= currInt.start){
                prevInt.end = Math.max(prevInt.end, currInt.end);
            } else {
                res.add(new Interval(prevInt.end, currInt.start));
                prevInt = currInt;
            }
        }

        return res;
    }
}
