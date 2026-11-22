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
        if(intervals.isEmpty()){
            return true;
        }
        intervals.sort((x, y) -> { 
            if(x.start == y.start){
                return Integer.compare(x.end, y.end);
            }else {
                return Integer.compare(x.start, y.start);
            }});
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(int i=1; i<intervals.size() ; i++ ){
            Interval cur = intervals.get(i);
            if(end > cur.start || start == cur.start){
                return false;
            }
            end = cur.end;
            start = cur.start;
        }

        return true;
    }
}
