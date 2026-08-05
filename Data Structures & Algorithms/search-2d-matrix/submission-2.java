class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; 
        int n = matrix[0].length; 

        int u = 0; 
        int d = m-1; 

        if(matrix[0][0] > target || matrix[m-1][n-1]<target) return false;
        int rowNum = -1; 
        while(u<=d){
            int mid = u+ ((d-u)/2);
            
            if(matrix[mid][0] <= target && matrix[mid][n-1] >= target){
                rowNum = mid; 
                break;
            } else if(matrix[mid][0] > target) d--; 
            else u++; 
        }

        if(rowNum == -1) return false; 

        int l =0; 
        int r = n-1; 

        while(l<=r){
            int mid = l+ ((r-l)/2);
            
            if(matrix[rowNum][mid] == target ){
                return true; 
            } else if(matrix[rowNum][mid] > target) r--; 
            else l++; 
        }

        return false; 
    }
}
