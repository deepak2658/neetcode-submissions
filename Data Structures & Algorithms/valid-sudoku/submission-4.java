class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] freq;
        int[][] boxInd = new int[][]{{0,3,0,3},{3,6,3,6},{6,9,6,9},
        {0,3,3,6}, {0,3,6,9}, {3,6,0,3}, {3,6,6,9},
        {6,9,0,3}, {6,9,3,6}};

        // row wise check
        for( int i = 0; i < 9; i++){
            freq = new int[10];
            for( int j = 0; j < 9; j++){
                if(board[i][j] != '.')
                    freq[board[i][j]-'0']++;
            }
            for( int k = 0; k < 10; k++)
                if(freq[k] >1)
                    return false;
        }

        // col wise check
        for( int j = 0; j < 9; j++){
            freq = new int[10];
            for( int i = 0; i < 9; i++){
                    if(board[i][j] != '.')
                        freq[board[i][j]-'0']++;
            }

            for( int k = 0; k < 10; k++)
                if(freq[k] >1)
                    return false;
        }

        // per box check
        for(int[] limits: boxInd){
            freq = new int[10];
            for( int i = limits[0]; i < limits[1]; i++){
                for( int j = limits[2]; j < limits[3]; j++){
                    if(board[i][j] != '.')
                        freq[
                            board[i][j]-'0']++;
                }
            }

            for( int k = 0; k < 10; k++)
                if(freq[k] >1)
                    return false;            
        }

        return true;
    }
}
