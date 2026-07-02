class MaxStack {
    class NodeComparator implements Comparator<Node>{
        @Override
        public int compare(Node a, Node b){
            if(a.val != b.val)
                return Integer.compare(b.val, a.val);
            else
                return Integer.compare(b.counter, a.counter);
        }
    }

    class Node{
        public int val;
        public int counter;
        public Node prev;
        public Node next;

        public Node(int val, int counter){
            this.val = val;
            this.counter = counter;
        }
    }

    class CustomStack{
        public Node head;
        public Node tail;

        public CustomStack(){
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        public Node cpush(int val, int counter){
            Node newNode = new Node(val, counter);

            newNode.next = head.next;
            newNode.prev = head;

            head.next = newNode;
            newNode.next.prev = newNode;
            return newNode;
        }

        public Node cpop(){
            Node currNode = head.next;

            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;

            return currNode;
        }

        public void cRemove(Node currNode){
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
        }

        public int ctop(){
            return head.next.val;
        }
    }

    int counter;

    TreeSet<Node> treeSet;
    CustomStack stack;

    public MaxStack() {
        counter = 0;
        treeSet = new TreeSet<>(new NodeComparator());
        stack = new CustomStack();
    }
    
    public void push(int x) {
        counter++;
        String key = counter + "#" + x;

        Node newNode = stack.cpush(x, counter);
        // map.put(key, newNode);

        treeSet.add(newNode);
    }
    
    public int pop() {
        Node popedNode = stack.cpop();
        treeSet.remove(popedNode);

        return popedNode.val;
    }
    
    public int top() {
        return stack.ctop();
    }
    
    public int peekMax() {
        return treeSet.first().val;
    }
    
    public int popMax() {
        Node currNode = treeSet.pollFirst();

        stack.cRemove(currNode);

        return currNode.val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
