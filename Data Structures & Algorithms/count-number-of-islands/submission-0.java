class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int count = 0;
        for( int i = 0; i < n; i++){
            for( int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    // System.out.println(i + " " + j);
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    count++;

                    while(queue.size() != 0){
                        int[] node = queue.poll();
                        int curri = node[0];
                        int currj = node[1];
                        grid[curri][currj] = '0';

                        for( int direction[]: directions){
                            int newi = curri + direction[0];
                            int newj = currj + direction[1];

                            if( newi < 0 || newi>=n || 
                                newj < 0 || newj >=m || grid[newi][newj] == '0')
                                continue;

                            queue.add(new int[]{newi, newj});
                        }
                    }
                }
            }
        }

        return count;
    }
}
