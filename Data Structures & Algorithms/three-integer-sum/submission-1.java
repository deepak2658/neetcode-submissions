class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> dupChecker = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        for( int i = 0; i < nums.length; i++){
            HashSet<Integer> set = new HashSet<>();
            for( int j = i+1; j < nums.length; j++){
                if( set.contains((nums[i] + nums[j])*-1) ){
                    List<Integer> mini = new ArrayList<>();
                    mini.add(nums[i]);
                    mini.add(nums[j]);
                    mini.add((nums[i] + nums[j])*-1);

                    Collections.sort(mini);
                    String key = mini.toString();

                    if(!dupChecker.contains(mini)){
                        res.add(mini);
                        dupChecker.add(mini);
                    }
                } else{
                    set.add(nums[j]);
                }
            }
        }

        return res;
    }
}
