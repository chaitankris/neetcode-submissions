class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (x,y) ->{
            return Integer.compare(x[0], y[0]);
        });
        int count = 0;
        int prev = Integer.MAX_VALUE; 
        // using greedy approach
        for(int[] i: intervals){
            if(prev == Integer.MAX_VALUE){
                prev = i[1];
                continue ;
            }

            if(prev > i[0]){
                prev = Math.min(prev, i[1]);
                count++;
            }else {
                prev = i[1];
            }
        }

        return count;
    }
}
