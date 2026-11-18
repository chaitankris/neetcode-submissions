class Solution {
    public int dfs(int[][] grid, int i, int j){
        if(i>grid.length-1 || j>grid[0].length-1||
         i<0 || j<0 || grid[i][j] == 0 || grid[i][j] == 2){
            return 0;
        }
        grid[i][j] = 2;

        return 1 + dfs(grid, i+1,j) +
                    dfs(grid, i-1, j) + dfs(grid, i,j+1) + dfs(grid, i,j-1); 
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}
