class Solution {
    int[] dest;
    class NodeComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            int v1 = Math.abs(a[0]-dest[0]) + Math.abs(a[1]-dest[1]);
            int v2 = Math.abs(b[0]-dest[0]) + Math.abs(b[1]-dest[1]);

            return Integer.compare(v1,v2);
        }
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dest = new int[]{destination[0], destination[1]};
        int n = maze.length;
        int m = maze[0].length;
        int[][] directions = new int[][]{
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };
        PriorityQueue<int[]> queue = new PriorityQueue<>(new NodeComparator());

        HashSet<String> visited = new HashSet<>();
        queue.add(new int[]{start[0],start[1]});
        // visited.add(start[0]+"#"+start[1]);
        
        int count = 4;
        while(queue.size()!=0){
            int[] node = queue.poll();
            // System.out.println(node[0] + " " + node[1]);

            int ux = node[0];
            int uy = node[1];

            if(ux == destination[0] && uy == destination[1])
                return true;

            if(visited.contains(ux+"#"+uy))
                continue;
            else
                visited.add(ux+"#"+uy);

            for(int[] direction : directions){
                int vx = ux;
                int vy = uy;
                if(direction[0] != 0){
                    while(vx+direction[0] >=0 && vx+direction[0]<n
                        && maze[vx+direction[0]][vy] != 1
                    ){
                        vx = vx + direction[0];
                    }
                }

                if(direction[1] != 0){
                    while(vy+direction[1] >=0 && vy+direction[1] <m
                    && maze[vx][vy+direction[1]] != 1)
                        vy = vy + direction[1];
                }

                String key = vx+"#"+vy;
                // System.out.println(key + " : " + ux+"||"+uy);
                if(visited.contains(key))
                    continue;

                queue.add(new int[]{vx, vy});
            }
        }

        return false;
    }
}
