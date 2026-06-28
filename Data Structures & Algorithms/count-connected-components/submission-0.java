class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n){
            this.parent = new int[n+1];
            for( int i =1; i < n+1; i++)
                this.parent[i] = i;
            this.rank = new int[n+1];
        }

        public int find(int node){
            if(this.parent[node] == node)
                return node;

            this.parent[node] = find(this.parent[node]);

            return this.parent[node];
        }

        public boolean union(int a, int b){
            int parentA = this.find(a);
            int parentB = this.find(b);

            if(parentA == parentB)
                return false;

            if(this.rank[parentA] < this.rank[parentB]){
                parent[parentA] = parentB;
            }else if(this.rank[parentA] > this.rank[parentB]){
                parent[parentB] = parentA;
            } else {
                parent[parentB] = parentA;
                rank[parentA]++;
            }

            return true;
        }
    }

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];

            if(dsu.union(a,b))
                n--;
        }

        return n;
    }
}
