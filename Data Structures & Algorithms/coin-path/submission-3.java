class Solution {
    int jumpMax = 0;
    int minCost;
    List<String> resString;
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        jumpMax = maxJump;
        minCost = Integer.MAX_VALUE;
        resString = new ArrayList<>();
        backtrack(coins, 0, 0, new StringBuilder("1"));

        if(resString.size() == 0)
            return new ArrayList<>();
        // System.out.println(resString);
        Collections.sort(resString);
        // System.out.println(resString.toString());

        String[] indexes = resString.get(0).split("#");
        List<Integer> res = new ArrayList<>();
        for( String index: indexes)
            if(index != "")
                res.add(Integer.parseInt(index));

        return res;
        
    }

    public void backtrack(int[] coins, int index, int cost, StringBuilder sb){
        if(index > coins.length-1)
            return;

        if( index == coins.length-1){
        // System.out.println( "-- " + sb.toString());
            if(cost < minCost){
                minCost = cost;
                resString.clear();
                resString.add(sb.toString());
            }

            if(cost == minCost){
                resString.add(sb.toString());
            }

            return;
        }

        for( int i = 1; i <= jumpMax; i++){
            int len = sb.length();
            int newIndex = i+index;

            if(newIndex >= coins.length || coins[newIndex] == -1)
                continue;
            int upd = newIndex + 1;
            sb.append("#" +(upd));
            backtrack(coins, newIndex, cost + coins[newIndex], new StringBuilder(sb.toString()));
            sb.setLength(len);
        }
    }
}
