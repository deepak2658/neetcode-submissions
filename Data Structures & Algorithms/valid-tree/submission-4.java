class Solution {
    class DSU{
        int[] parent, rank;

        DSU(int n ){
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int a){
            if(parent[a] == a) return a;

            parent[a] = find(parent[a]);

            return parent[a];
        }

        public boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return false;

            if(rank[pa] < rank[pb]){
                int t = pa;
                pa = pb;
                pb = t;
            }

            parent[pb] = pa;

            if(rank[pa] == rank[pb])
                rank[pa]++;

            return true;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for(int[] edge: edges){
            if(dsu.union(edge[0], edge[1]))
                n--;
            else
                return false;
        }

        return n != 1 ? false: true;
    }
}
