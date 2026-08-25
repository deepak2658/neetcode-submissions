class Solution {
    class DSU {
        int[] parent, rank;

        public DSU(int n ){
            parent= new int[n];
            rank = new int[n];
            for(int i= 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int a) {
            if(parent[a] == a) return a;

            return parent[a] = find(parent[a]);
        }

        public boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb)
                return false;
            
            if(rank[pa] < rank[pb]){
                int temp = pa;
                pa= pb;
                pb = temp;
            }

            parent[pb] = pa;

            if(rank[pa] == rank[pb]) rank[pa]++;

            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        DSU dsu = new DSU(n);
        int[] res = new int[0];
        for(int[] edge: edges){
            if(!dsu.union(edge[0], edge[1]))
                res = edge;
        }

        return res;
    }
}
