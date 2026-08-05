class Solution {
    Set<Integer> visited; 
    Map<Integer,List<Integer>> graph; 
    boolean res; 
    public boolean validTree(int n, int[][] edges) {
        visited = new HashSet<>(); 
        graph = new HashMap<>(); 
        res=false;
        int prev = -1; 

        for(int i=0;i<n;++i){
            graph.put(i,new ArrayList<>()); 
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]); 
            graph.get(edge[1]).add(edge[0]); 
        }

        return detectCycle(0,-1) && visited.size()==n; 

    }

    private boolean detectCycle(int x, int prev){
        if(visited.contains(x) || x==prev) return false; 
        visited.add(x); 
        for(int y: graph.get(x)){
            if(y==prev) continue; 
            res=detectCycle(y,x);
            if(res==false) return res; 
        }
        return true; 
    }
}
