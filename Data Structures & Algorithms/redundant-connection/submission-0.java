class Solution {
    int cycleStart = -1; 
    Map<Integer, List<Integer>> map = new HashMap<>(); 
    Set<Integer> cycleSet = new HashSet<>(); 
    boolean[] visited; 
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 
        visited = new boolean[n+1]; 
        for(int i=1;i<=n;++i){
            map.put(i,new ArrayList<>()); 
        }

        for(int[] edge : edges){
            int u = edge[0]; 
            int v = edge[1]; 
            map.get(u).add(v); 
            map.get(v).add(u); 
        }

        dfs(1,-1); 

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0], v = edges[i][1];
            if (cycleSet.contains(u) && cycleSet.contains(v)) {
                return new int[]{u, v};
            }
        }
        return new int[0];
    }

    public boolean dfs(int node, int parent){
        if(visited[node]){
            cycleSet.add(node); 
            cycleStart = node; 
            return true; 
        }

        visited[node] = true; 
        for(int nei : map.get(node)){
            if(nei == parent) continue; 

            if(dfs(nei,node)){
                if(cycleStart!=-1){
                    cycleSet.add(node); 
                }
                if(node == cycleStart){
                    cycleStart = -1; 
                }
                return true; 
            }
        }
        return false; 
    }
}
