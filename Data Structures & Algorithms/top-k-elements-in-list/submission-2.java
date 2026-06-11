class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for( int num: nums){
            if(freq.containsKey(num)){
                freq.put(num, freq.get(num)+1);
            }else{
                freq.put(num, 1);
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));

        for( Integer key: freq.keySet()){
            queue.add(new int[]{key, freq.get(key)});
        }

        int[] res = new int[k];
        int index = 0;
        while(k > 0){
            int[] ele = queue.poll();
            res[index++] = ele[0];
            k--;
        }

        return res;
    }
}
