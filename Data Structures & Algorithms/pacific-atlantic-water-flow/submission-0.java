class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length; 
        int n = heights[0].length; 
        Set<Pair<Integer,Integer>> pacific = new HashSet<>(); 
        Set<Pair<Integer,Integer>> atlantic = new HashSet<>(); 

        int[][] directions = new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(i==0 || j==0){
                    pacific.add(new Pair(i,j)); 
                }
                if(i==m-1 || j==n-1){
                    atlantic.add(new Pair(i,j)); 
                }
            }
        }

        Queue<Pair<Integer,Integer>> qa = new LinkedList<>();
        for(Pair<Integer,Integer> pair : atlantic){
            qa.offer(pair); 
        } 

        Queue<Pair<Integer,Integer>> qp = new LinkedList<>();
        for(Pair<Integer,Integer> pair : pacific){
            qp.offer(pair); 
        }

        while(!qa.isEmpty()){
            Pair<Integer,Integer> curr = qa.poll(); 
            int i = curr.getKey(); 
            int j = curr.getValue(); 

            for(int[] dir:directions){
                int x = i+dir[0]; 
                int y = j+dir[1];
                if(x>=0 && y>=0 && x<m && y<n && heights[x][y]>=heights[i][j] && !atlantic.contains(new Pair(x,y))){
                    atlantic.add(new Pair(x,y));
                    qa.offer(new Pair(x,y)); 
                } 
            }
        }

        while(!qp.isEmpty()){
            Pair<Integer,Integer> curr = qp.poll(); 
            int i = curr.getKey(); 
            int j = curr.getValue(); 

            for(int[] dir:directions){
                int x = i+dir[0]; 
                int y = j+dir[1];
                if(x>=0 && y>=0 && x<m && y<n && heights[x][y]>=heights[i][j] && !pacific.contains(new Pair(x,y))){
                    pacific.add(new Pair(x,y));
                    qp.offer(new Pair(x,y)); 
                } 
            }
        }        

        List<List<Integer>> res = new ArrayList<>(); 
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                Pair<Integer,Integer> p = new Pair(i,j); 
                if(atlantic.contains(p) && pacific.contains(p)){
                    res.add(List.of(i,j)); 
                }
            }
        }

        return res; 

    }
}