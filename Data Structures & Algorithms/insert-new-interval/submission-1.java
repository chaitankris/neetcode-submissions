class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean tobeint = true;
        int siz = 0;
        for (int[] i : intervals) {
            // to be inserted
            if (tobeint) {
                if (i[1] < newInterval[0]) {
                    result.add(new int[] {i[0], i[1]});
                } else if (newInterval[1] < i[0]) {
                    // newInterval comes strictly before current interval (no overlap)
                    result.add(new int[] {newInterval[0], newInterval[1]});
                    result.add(new int[] {i[0], i[1]});
                    tobeint = false;
                } else {
                    result.add(
                        new int[] {Math.min(i[0], newInterval[0]), Math.max(i[1], newInterval[1])});
                    tobeint = false;
                }
            } else {
                int[] prev = result.getLast();
                if (prev[1] < i[0]) {
                    result.add(new int[] {i[0], i[1]});
                } else {
                    result.set(result.size() - 1,
                        new int[] {Math.min(i[0], prev[0]), Math.max(i[1], prev[1])});
                }
            }
            siz++;
        }

        if (tobeint) {
            result.add(new int[] {newInterval[0], newInterval[1]});
        }

        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
