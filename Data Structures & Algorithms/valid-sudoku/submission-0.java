class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();

        //check rows
        for(int i=0; i<9; i++){
            set.clear();
            for(int j=0; j<9; j++){
                if(board[i][j] != '.' && set.contains(board[i][j])){
                      return false;
                }
                set.add(board[i][j]);
            }
        }

        //check cols
        for(int i=0; i<9; i++){
            set.clear();
            for(int j=0; j<9; j++){
                if(board[j][i] != '.' && set.contains(board[j][i])){
                    return false;
                }
                set.add(board[j][i]);
            }
        }

        //check small boxes
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9;j+=3){
                set.clear();
                for(int p=i; p<i+3; p++){
                    for(int q=j; q<j+3; q++){
                        if(board[p][q] != '.' && set.contains(board[p][q])){
                            return false; 
                        }
                        set.add(board[p][q]);
                    }
                }
                
            }
        }


        return true;
    }
}
