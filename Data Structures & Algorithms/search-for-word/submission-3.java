class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[] res = new boolean[1]; 
        res[0] = false; 
        for(int i = 0; i < board.length ; ++i){
            for(int j = 0; j< board[0].length; ++j){
                if(word.charAt(0) == board[i][j]){
                    boolean[][] visited = new boolean[board.length][board[0].length]; 
                    dfs(board,word,i,j,0,res,visited); 
                }
            }
        }

        return res[0]; 
    }

    private static void dfs(char[][] board, String word, int i, int j, int c, boolean[] res, boolean[][] visited){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || c>=word.length() || visited[i][j]) return; 
        if(word.charAt(c)==board[i][j]){
            visited[i][j] = true; 
            if(c==word.length()-1){
                res[0]=true; 
                return; 
            }
            dfs(board,word,i+1,j,c+1,res,visited);
            dfs(board,word,i-1,j,c+1,res,visited);
            dfs(board,word,i,j+1,c+1,res,visited);
            dfs(board,word,i,j-1,c+1,res,visited);
            visited[i][j] = false;
        }
        return; 
    }
}
