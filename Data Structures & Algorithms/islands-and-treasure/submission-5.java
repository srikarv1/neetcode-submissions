class Solution {
    int[][] directions = new int[][]{
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    }; 
    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length; 
        int n = grid[0].length; 

        Queue<String> q = new ArrayDeque<>(); 
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j] == 0){
                    String key = i+","+j; 
                    q.offer(key); 
                }
            }
        }
        int score =1; 
        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i=0;i<size;++i){
                String curr = q.poll(); 
                String s[] = curr.split(","); 
                int x = Integer.parseInt(s[0]); 
                int y =  Integer.parseInt(s[1]); 
                for(int[] dir : directions){
                    int new_x = dir[0]+x; 
                    int new_y = dir[1]+y; 
                    String k = new_x+","+new_y;
                    if(new_x >=0 && new_y>=0 && new_x<m && new_y<n && grid[new_x][new_y] == 2147483647 && grid[new_x][new_y] != -1 && grid[new_x][new_y] != 0){
                        grid[new_x][new_y]=score; 
                        q.offer(k);
                    }
                }
            }
            score++; 
        }
    }
}
