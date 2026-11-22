class Solution {

    public record Pair(int x, int y){};
    public void dfs(int[][] heights, HashSet<Pair> set, int prev, int r, int c){
        if(r>= heights.length || c>=heights[0].length || c<0 || r<0 || set.contains(new Pair(r,c)) ||
            heights[r][c]<prev)
        {
        return;
        }

        set.add(new Pair(r,c));
        dfs(heights, set, heights[r][c], r+1, c);
        dfs(heights, set, heights[r][c], r-1, c);
        dfs(heights, set, heights[r][c], r, c+1);
        dfs(heights, set, heights[r][c], r, c-1);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        HashSet<Pair> pac = new HashSet<>();
        HashSet<Pair> alt = new HashSet<>();

        for(int i=0; i<r; i++){
            dfs(heights, pac, heights[i][0], i, 0);
            dfs(heights, alt, heights[i][c-1], i, c-1);
        }

        for(int j=0; j<c; j++){
            dfs(heights, pac, heights[0][j], 0, j);
            dfs(heights, alt, heights[r-1][j], r-1, j );
        }

        List<List<Integer>> res = new ArrayList<>();

        pac.retainAll(alt);

        for(Pair p: pac){
            res.add(List.of(p.x, p.y));
        }

        return res;
    }
}
