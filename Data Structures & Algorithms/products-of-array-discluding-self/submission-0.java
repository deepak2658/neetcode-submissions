class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrProd = 1;
        int zeroCount = 0;
        for(int ele: nums){
            if(ele == 0)
                zeroCount++;
            else
                arrProd *= ele;
        }

        int[] res = new int[nums.length];
        if(zeroCount > 1)
            return res;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(zeroCount == 1)
                    res[i] = arrProd;
            }
            else{
                if(zeroCount != 0)
                    res[i] = 0;
                else
                    res[i] = arrProd/nums[i];
            }
        }

        return res;
    }
}  
