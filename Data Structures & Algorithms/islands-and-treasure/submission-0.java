class Solution {
    public void bfs(int r, int c, int[][] grid, int dis, Queue<Pair> q){
        if(r >=grid.length || c>= grid[0].length || r<0 || c<0
            || grid[r][c] == -1 || grid[r][c] != 2147483647 ){
            return ;
        }

        grid[r][c] = dis; 
        q.offer(new Pair(r,c));
    }
    public record Pair(int x, int y){};
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        //Add all 0 pos to queue
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 0){
                    q.offer(new Pair(i,j));
                }
            }
        }

        int dis = 1;
        
        // run the bfs from all the treasure points
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair cur = q.poll();
                bfs(cur.x-1, cur.y, grid, dis, q);
                bfs(cur.x+1, cur.y, grid, dis, q);
                bfs(cur.x, cur.y-1, grid, dis, q);
                bfs(cur.x, cur.y+1, grid, dis, q);
            }
            dis = dis + 1;
        }

    }
}
