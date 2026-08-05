class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        int[] res = new int[1]; 
        boolean[][] visited = new boolean[m][n];
        for (boolean[] row : visited) {
            Arrays.fill(row, false); 
        }
        for(int i=0; i<m ;++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    int area[] = new int[1]; 
                    dfs(grid,visited,i,j,area);
                    res[0] = Math.max(res[0],area[0]);  
                }
            }
        }
        return res[0];
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j, int[] area){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j] == 0 || visited[i][j] == true) 
        return; 

        visited[i][j] = true; 
        area[0]++; 
        dfs(grid,visited,i+1,j,area); 
        dfs(grid,visited,i-1,j,area); 
        dfs(grid,visited,i,j+1,area); 
        dfs(grid,visited,i,j-1,area); 
    }
}