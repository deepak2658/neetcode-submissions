class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int size = 1;
        int max = 1; // FIX

        for(int right = 1; right < nums.length; right++){

            if(nums[right] == nums[right - 1]){
                continue; // FIX: ignore duplicates
            }
            else if(nums[right] == nums[right - 1] + 1){
                size++;
            }
            else{
                size = 1; // FIX: restart sequence
            }

            max = Math.max(max, size);
        }

        return max;
    }
}