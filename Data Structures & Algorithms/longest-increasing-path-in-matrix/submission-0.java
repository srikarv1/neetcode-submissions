class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res =0;
        int[][] dp = new int [m][n]; 
        for(int i=0; i<m; ++i){
            for(int j=0;j<n;++j){
               int[][] copy = new int[matrix.length][]; 
               for(int k =0; k<m; ++k) copy[k] = matrix[k].clone();
               res = Math.max(res,dfs(i,j,copy,dp,-1));
            }
        }
        return res;
    }

    private static int dfs(int i, int j, int[][] matrix, int[][] dp, int prev){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]<=prev) return 0;
        if(dp[i][j]!=0) return dp[i][j]; 
        int curr = matrix[i][j]; 
        int up = dfs(i-1,j,matrix,dp,curr);
        int down = dfs(i+1,j,matrix,dp,curr);
        int left = dfs(i,j-1,matrix,dp,curr);
        int right = dfs(i,j+1,matrix,dp,curr);
        dp[i][j] = 1 + Math.max(Math.max(up,down), Math.max(left,right));

        return dp[i][j];
    }
}