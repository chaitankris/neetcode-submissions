class Solution {

    public record Pair(int x,int y){};
    public void bfs(int r, int c, int[][] grid, Queue<Pair> q){
        if(r>= grid.length || c>= grid[0].length || r < 0 || c<0 ||
            grid[r][c] == 0 || grid[r][c] == 2){
            return ;
        }

        grid[r][c] = 2;
        q.add(new Pair(r,c));
    }
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(q.isEmpty()){
            return fresh == 0 ? 0 : -1;
        }

        int min = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                Pair cur = q.poll();
                bfs(cur.x-1, cur.y, grid, q);
                bfs(cur.x+1, cur.y, grid, q);
                bfs(cur.x, cur.y-1, grid, q);
                bfs(cur.x, cur.y+1, grid, q);
            }
            min++;
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                   return -1 ;
                }
            }
        }

        return min-1;
    }
}
