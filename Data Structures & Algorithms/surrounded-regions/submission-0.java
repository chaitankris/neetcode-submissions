class Solution {
    public record Pair(int x, int y){};

    public void bfs(int r, int c, char[][] board, Queue<Pair> q){
        // constraints
        if(r> board.length-1 || c>board[0].length-1 || r<0 || c<0 || 
           board[r][c] == '#' || board[r][c] == 'X' ){
            return; 
        }
        q.add(new Pair(r,c));
    }

    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        Queue<Pair> q = new LinkedList<>();
        // Add to queue, All the border ones could not be surrounded 
        //because they have an edge, so we want to see what are the elements
        // which can be connected to the border ones.
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if( i == 0 || j == 0 || i == r-1 || j == c-1){
                    if(board[i][j] == 'O'){
                        q.add(new Pair(i,j));
                    }
                }
            }
        }
        
        // Traverse all the added items
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                Pair cur = q.poll();
                board[cur.x][cur.y] = '#';
                bfs(cur.x-1, cur.y, board, q);
                bfs(cur.x, cur.y-1, board, q);
                bfs(cur.x, cur.y+1, board, q);
                bfs(cur.x+1, cur.y, board, q);
            }
        }

        // set back the converted ones.
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
