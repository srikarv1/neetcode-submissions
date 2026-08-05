class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (boolean[] row : visited) {
            Arrays.fill(row, false); 
        }
        int res = 0; 
        for(int i=0; i<m ;++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    dfs(grid,visited,i,j);
                    res++; 
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int i, int j){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j] == '0' || visited[i][j] == true) 
        return; 

        visited[i][j] = true; 
        dfs(grid,visited,i+1,j); 
        dfs(grid,visited,i-1,j); 
        dfs(grid,visited,i,j+1); 
        dfs(grid,visited,i,j-1); 
    }
}
