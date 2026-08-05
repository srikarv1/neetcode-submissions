class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();

        if(heights.length == 0) return 0; 

        //start, height 
        stack.push(new int[]{0,heights[0]}); 
        int res = heights[0]; 
        for(int i=1; i<heights.length ;++i){
            int start = i; 
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top =  stack.pop();

                start = top[0];
                int ht = top[1]; 
                res = Math.max(res, (i-start) *ht); 
            }

            stack.push(new int[]{start,heights[i]}); 
        } 

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            res = Math.max(res, height * (heights.length - index));
        }


        return res; 
}
}
