class Solution {
    class Node {
        public int x;
        public int y;
        public int pathLength;
        public String currPath;

        public Node(int x, int y, int pathLength, String currPath) {
            this.x = x;
            this.y = y;
            this.pathLength = pathLength;
            this.currPath = currPath;
        }
    }

    HashMap<String, Character> map = new HashMap<>();

    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if (a.pathLength != b.pathLength)
                return Integer.compare(a.pathLength, b.pathLength);
            return a.currPath.compareTo(b.currPath);
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length;
        int m = maze[0].length;

        map.put("1#0", 'd');
        map.put("0#1", 'r');
        map.put("-1#0", 'u');
        map.put("0#-1", 'l');

        int[][] directions = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };

        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());

        // FIX 1: Instead of visited[][], maintain shortest distance and best path
        int[][] dist = new int[n][m];
        String[][] bestPath = new String[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[ball[0]][ball[1]] = 0;
        bestPath[ball[0]][ball[1]] = "";

        queue.add(new Node(ball[0], ball[1], 0, ""));

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            int ux = curr.x;
            int uy = curr.y;
            int wt = curr.pathLength;
            String path = curr.currPath;

            // FIX 2: Ignore stale states
            if (wt > dist[ux][uy])
                continue;

            if (wt == dist[ux][uy] && !path.equals(bestPath[ux][uy]))
                continue;

            // Dijkstra guarantees this is the answer
            if (ux == hole[0] && uy == hole[1])
                return path;

            for (int[] direction : directions) {

                int vx = ux;
                int vy = uy;

                int dx = direction[0];
                int dy = direction[1];

                String key = dx + "#" + dy;

                int steps = 0;

                // FIX 3: Roll until wall OR hole
                while (vx + dx >= 0 && vx + dx < n &&
                       vy + dy >= 0 && vy + dy < m &&
                       maze[vx + dx][vy + dy] != 1) {

                    vx += dx;
                    vy += dy;
                    steps++;

                    // Stop rolling once the hole is reached
                    if (vx == hole[0] && vy == hole[1])
                        break;
                }

                String newPath = path + map.get(key);

                // FIX 4: Update if shorter OR same distance but lexicographically smaller
                if (wt + steps < dist[vx][vy] ||
                   (wt + steps == dist[vx][vy] &&
                    (bestPath[vx][vy] == null ||
                     newPath.compareTo(bestPath[vx][vy]) < 0))) {

                    dist[vx][vy] = wt + steps;
                    bestPath[vx][vy] = newPath;

                    queue.add(new Node(vx, vy, wt + steps, newPath));
                }
            }
        }

        return "impossible";
    }
}