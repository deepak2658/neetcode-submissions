class Solution {
    class DSU { 
        int[] parent;
        int[] rank;

        public DSU(int n){
            parent = new int[n+1];
            for( int i = 1; i < n+1; i++)
                parent[i] = i;

            rank = new int[n+1];
        }

        public int find(int node){
            if(parent[node] == node)
                return node;

            parent[node] = find(parent[node]);

            return parent[node];
        }

        public boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb)
                return false;

            if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            } else if(rank[pa] > rank[pb]){
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];

            if(dsu.union(a, b) == false)
                return false;
            else
                n--;
        }

        if(n>1)
            return false;
        else
            return true;
    }
}
