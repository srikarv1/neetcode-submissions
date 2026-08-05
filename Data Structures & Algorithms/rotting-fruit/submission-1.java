class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>(); 
        int m = grid.length; 
        int n = grid[0].length; 
        
        int[][] directions = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        int res =0; 
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    res=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;++k){
                int[] curr = q.poll();
                int i = curr[0]; 
                int j= curr[1];  
                for(int[] dir:directions){
                    int x = dir[0]+i; 
                    int y = dir[1]+j;

                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                        grid[x][y] = 2; 
                        q.offer(new int[]{x,y}); 
                    } 
                }
            }
            res++;  
        }

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1)
                    return -1;  
            }
        }

        return res; 

    }
}
