class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        for(int i = 0; i < 9; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }

        int[][] miniBoxi = new int[][]{
                                {0,2}, {3,5}, {6,8}};
        int[][] miniBoxj = new int[][]{
                                {0,2}, {3,5}, {6,8}};


        for(int[] rowBound: miniBoxi){
            int iStart = rowBound[0];
            int iEnd = rowBound[1];
            for(int[] colBound: miniBoxj){
                HashSet<Character> boxSet = new HashSet<>();
                int jStart = colBound[0];
                int jEnd = colBound[1];

                for(int i =iStart; i <= iEnd; i++){
                    for(int j = jStart; j <= jEnd; j++){
                        char currEle = board[i][j];
                        if(currEle == '.')
                            continue;

                        if(rowSet[i].contains(currEle))
                            return false;
                        else
                            rowSet[i].add(currEle);
                        
                        if(colSet[j].contains(currEle))
                            return false;
                        else
                            colSet[j].add(currEle);

                        if(boxSet.contains(currEle))
                            return false;
                        else
                            boxSet.add(currEle);
                    }
                }
            }
        }

        return true;
    }
}