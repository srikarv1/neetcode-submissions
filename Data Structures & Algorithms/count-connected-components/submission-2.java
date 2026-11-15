class Solution {
    Map<Integer, List<Integer>> map; 
    public int countComponents(int n, int[][] edges) {
        map = new HashMap<>(); 
        for(int i=0;i<n;++i){
            map.put(i,new ArrayList<>()); 
        }

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int res = 0; 
        boolean[] vis = new boolean[n]; 
        for(int i=0;i<n;++i){
            if(!vis[i]){
                res++; 
                dfs(i,vis,-1); 
            }
        }
        return res; 
    }

    public void dfs(int i, boolean[] vis, int parent){
        if(vis[i]) return; 

        vis[i] = true; 
        for(int num : map.get(i)){
            //if(num == parent) continue; 
            dfs(num,vis,i); 
        }
    }
}
