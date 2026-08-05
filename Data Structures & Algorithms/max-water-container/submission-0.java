class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length; 
        int i=0, j=n-1;

        int res = Integer.MIN_VALUE; 
        while(i<j){
            int length = j-i; 
            res = Math.max(res, length* Math.min(heights[i],heights[j])); 

            if(heights[i]>=heights[j]) j--;
            else i++;
        }

        return res; 
    }
}
