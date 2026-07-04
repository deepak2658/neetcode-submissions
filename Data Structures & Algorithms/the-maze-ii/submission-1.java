class Solution {
    int[] dest;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        dest = new int[]{destination[0], destination[1]};
        int[][] directions = new int[][]{
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0],b[0])
        );
        queue.add(new int[]{0, start[0], start[1]});

        while(queue.size()!=0){
            int[] node = queue.poll();
            int ux = node[1];
            int uy = node[2];
            int currWt = node[0];

            if(ux == dest[0] && uy == dest[1])
                return currWt;

            if(visited[ux][uy])
                continue;
            else
                visited[ux][uy] = true;

            for(int[] direction: directions){
                int vx= ux;
                int vy = uy;

                int xd = direction[0];
                int yd = direction[1];
                int pathAddition = 0;


                if(direction[0] != 0){
                    while(vx+xd >= 0 && vx+xd <n && maze[vx+xd][vy]==0){
                        vx = vx+xd;
                        pathAddition++;
                    }
                } else {
                    while(vy+yd >= 0 && vy+yd <m && maze[vx][vy+yd]==0){
                        vy = vy+yd;
                        pathAddition++;
                    }
                }

                if(visited[vx][vy])
                    continue;

                queue.add(new int[]{currWt+ pathAddition, vx, vy});
            }
        }

        return -1;
    }
}
