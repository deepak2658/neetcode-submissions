class Solution {
    class Node{
        public int ele;
        public int state;

        Node(int ele, int state){
            this.ele = ele;
            this.state = state;
        }
    }

    class WaitingList{
        PriorityQueue<Node> exitList, entryList;

        WaitingList(){
            this.exitList = new PriorityQueue<>((a, b) -> Integer.compare(a.ele, b.ele));
            this.entryList = new PriorityQueue<>((a, b) -> Integer.compare(a.ele, b.ele));
        }

        boolean add(Node node){
            if(node.state == 0)
                entryList.add(node);
            if(node.state == 1)
                exitList.add(node);

            return true;
        }

        Node getFirst(Integer prevState) {

            if (entryList.isEmpty() && exitList.isEmpty())
                return null;

            if (prevState == null) {
                // prefer exit then entry
                return !exitList.isEmpty() ? exitList.poll() : entryList.poll();
            }

            if (prevState == 0) {
                // prefer entry
                return !entryList.isEmpty() ? entryList.poll() : exitList.poll();
            }

            // prefer exit
            return !exitList.isEmpty() ? exitList.poll() : entryList.poll();
        }

        int size(){
            return exitList.size() + entryList.size();
        }

        void print(){
            System.out.println("Entry: " + entryList.toString() + " Exit: " + exitList.toString());
        }
    }

    public int[] timeTaken(int[] arrival, int[] state) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        WaitingList wl = new WaitingList();
        int n = arrival.length;
        int[] res = new int[n];

        for(int i =0 ;i < n; i++){
            int time = arrival[i];
            // System.out.println(time + " " +map);
            if(map.containsKey(time)){
                map.get(time).add(i);
            }else{
                map.put(time, new ArrayList<>());
                map.get(time).add(i);
            }
        }

        int timer = 0;
        Integer prevExit = null;
        int elementProcessed = 0;
        while(elementProcessed < n){
            // System.out.println(elementProcessed);
            if(map.containsKey(timer)){
                List<Integer> elements = map.get(timer);
                for(int ele: elements){
                    Node node = new Node(ele, state[ele]);
                    wl.add(node);
                }
            }
            if(wl.size() == 0){
                timer++;
                prevExit = null; 
                continue;
            }

            // wl.print();
            Node node = wl.getFirst(prevExit);
            // System.out.println(wl.size() + " " + node.ele);
            res[node.ele] = timer;
            elementProcessed++;
            prevExit = node.state;
            timer++;
        }

        return res;
    }
}
