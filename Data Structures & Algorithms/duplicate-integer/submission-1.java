class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int ele: nums){
                set.add(ele);
        }

        if(set.size()!=nums.length)
            return true;
        else
            return false;
    }
}