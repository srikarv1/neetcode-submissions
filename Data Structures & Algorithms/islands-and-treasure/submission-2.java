class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>(); 
        int[][] directions = new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll(); 
            int i = curr[0]; 
            int j = curr[1]; 
            for(int[] dir : directions){
                int x = curr[0]+dir[0]; 
                int y = curr[1]+dir[1]; 

                if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y] == Integer.MAX_VALUE){
                    grid[x][y] = grid[i][j]+1; 
                    q.offer(new int[]{x,y});
                }
            }
        }
    }
}
