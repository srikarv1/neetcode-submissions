class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i=0; 
        int j=n-1;

        int res = 0; 
        while(i<j){
            res=Math.max(res, (j-i)*(Math.min(heights[i],heights[j]))); 
            if(heights[i]>heights[j]) j--; 
            else i++; 
        }

        return res; 
    }
}
