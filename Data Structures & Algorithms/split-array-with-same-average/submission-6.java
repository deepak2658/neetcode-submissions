class Solution {
    boolean res = false;
    int totalSum = 0;
    HashMap<String, Boolean> dpMap;

    public boolean splitArraySameAverage(int[] nums) {
        int index = nums.length-1;
        dpMap = new HashMap<>();
        
        for(int num: nums)
            totalSum += num;

        return backtrack(nums, index, 0, 0);

        // return res;
    }

    public double avg(int sum, int n){
        return ((double)sum) / ((double)n);
    }

    public boolean backtrack(int[] nums, int index, int s1, int n1){
        if (n1 > nums.length / 2)
            return false;
        if(index < 0){
            if (n1 == 0 || n1 == nums.length)
                return false;

            return s1 * nums.length == totalSum * n1;
        }

        // double a1 = avg(s1, n1);
        // double a2 = avg(s2, n2);

        String key =  s1 + "#" + n1;

        if(dpMap.containsKey(key))
            return dpMap.get(key);

        boolean tos1 = backtrack(nums, index-1, s1+nums[index], n1+1);
        boolean tos2 = backtrack(nums, index-1, s1, n1);

        dpMap.put(key, tos1 || tos2);
        return dpMap.get(key);
    }
}