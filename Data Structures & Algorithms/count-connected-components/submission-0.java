class Solution {
    HashMap<Integer,List<Integer>> graph; 
    Set<Integer> visited; 
    public int countComponents(int n, int[][] edges) {
        int res =0; 
        graph = new HashMap<>(); 
        visited = new HashSet<>();

        for(int i=0;i<n;++i){
            graph.put(i,new ArrayList<>()); 
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]); 
            graph.get(edge[1]).add(edge[0]); 
        }
        
        for(int i=0;i<n;++i){
            if(!visited.contains(i)){
                dfs(i);
                res++; 
            }
        }
        return res; 
    }

    private void dfs(int x){
        if(visited.contains(x)) return; 
        visited.add(x);
        for(int y:graph.get(x)){
            dfs(y); 
        }
    }
}
