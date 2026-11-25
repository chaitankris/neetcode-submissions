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

        if(intervals.isEmpty()){
            return 0;
        }

        intervals.sort((x,y)-> {
            if(x.start == y.start){
                return Integer.compare(x.end, y.end);
            }else{
                return Integer.compare(x.start, y.start);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue();
        int min = 0;
        for(Interval i: intervals){
            // Free up all rooms whose meetings have ended before or at i.start
            while(!pq.isEmpty() && pq.peek() <= i.start){
                pq.poll();
            }

            pq.add(i.end);
            min = Math.max(min, pq.size());
        }

        return min;
    }
}
