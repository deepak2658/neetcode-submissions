/**
 * // This is the robot's control interface.
 * // You should not implement 12345
/** * // This is the robot's control interface. * // $0it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    boolean[][] visited;
    HashMap<Character, int[]> dirMap;
    HashMap<Character, Character> newD= new HashMap<>();
    public void cleanRoom(Robot robot) {
        visited = new boolean[201][401];
        dirMap = new HashMap<>();
        dirMap.put('u',new int[]{-1, 0});
        dirMap.put('r',new int[]{0, 1});
        dirMap.put('d',new int[]{1, 0});
        dirMap.put('l', new int[]{0, -1});

        newD.put('u','r');
        newD.put('r','d');
        newD.put('d','l');
        newD.put('l', 'u');

        int i = 101;
        int j = 201;
        char direction = 'u';
        visited[i][j] = true;

        backtrack(robot, i, j, direction);
    }

    public void backtrack(Robot robo, int i, int j, char dir){
        // if(visited[i][j])
        //     return;

        robo.clean();

        // check in every direction move while cleaning.
        // firstly curr direction
        int fCount = 0;
        for(int l =0; l < 4; l++){
            int newi = i+ dirMap.get(dir)[0];
            int newj = j + dirMap.get(dir)[1];

            if(!visited[newi][newj] && robo.move()){
                visited[newi][newj] = true;
                backtrack(robo, newi, newj, dir);
                robo.turnRight();
                robo.turnRight();
                robo.move();
                robo.turnRight();
                robo.turnRight();
            }

            dir = newD.get(dir);
            robo.turnRight();
        }

        // if(fCount == 4)
        //     return
    }
}
