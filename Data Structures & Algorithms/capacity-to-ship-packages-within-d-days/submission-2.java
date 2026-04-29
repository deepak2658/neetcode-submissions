class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int maxWeight = Integer.MIN_VALUE;

        for(int weight : weights){
            sum+= weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int res = sum;

        int left = maxWeight;
        int right = res;

        while(left <= right){
            int mid = left + (right-left)/2;

            int totalDays = computeTotalDays(weights, mid);

            if(totalDays > days){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    int computeTotalDays(int[] weights, int capacity){
        int daysCount = 1;
        int currCapacity = capacity;

        for(int weight: weights){
            if(weight> currCapacity){
                daysCount++;
                currCapacity = capacity - weight;
            }else{
                currCapacity -= weight;
            }
        }

        return daysCount;
    }
}