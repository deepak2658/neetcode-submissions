class KthLargest {
    PriorityQueue<Integer> pq;
    int K;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>((a,b) -> a-b);
        this.K = k;

        for(int ele: nums){
            this.pq.add(ele);
            if(this.pq.size() > k)
                this.pq.poll();
        }
    }
    
    public int add(int val) {
        this.pq.add(val);

        if(this.pq.size() > K)
            this.pq.poll();

        return pq.peek();
    }
}