class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length == 1){
            return intervals;
        }

        List<int[]> list = new ArrayList<>();
        // Sort the 2d array based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        list.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] prev = list.getLast();
            // non-overlap
            if(prev[1]<intervals[i][0]){
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }else {
                list.set(list.size()-1, new int[]{
                    Math.min(prev[0], intervals[i][0]),
                    Math.max(prev[1], intervals[i][1]),
                } );
            }
            
        }

        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
