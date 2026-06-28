class Solution {
    boolean globalVisited[];
    boolean visited[];
    public boolean validTree(int n, int[][] edges) {
        // check cycle in graph using dfs
        globalVisited = new boolean[n];
        visited = new boolean[n];

        // graph initialization
        List<List<Integer>> graph = new ArrayList<>();
        for( int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        for(int i =0; i < n; i++){
            if(globalVisited[i] == false){
                components++;
                boolean isCycle = dfs(graph, i, visited, -1);
                // System.out.println(isCycle);
                if(isCycle)
                    return false;
            }
        }

        if(components > 1)
            return false;
        else
            return true;
    }

    public boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, int parent){
        visited[node] = true;
        globalVisited[node] = true;

        boolean isCycle = false;
        for(int v: graph.get(node)){
            if(visited[v] && v != parent){
                // System.out.println("is cucle");
                isCycle = true;
            }

            if(visited[v])
                continue;

            visited[v] = true;
            if(dfs(graph, v, visited, node))
                isCycle = true;
            visited[v] = false;
        }
        // System.out.println(isCycle);
        return isCycle;
    }
}
