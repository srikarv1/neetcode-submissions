class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;  
        backtrack(cost,-1,res,0);
        return res[0]; 
    }

    private static void backtrack(int[] cost, int position, int[] res, int steps){
        if(position >= cost.length){
            if(steps<res[0])
            res[0] = steps; 
            return; 
        }
        if(position>=0)
        steps += cost[position]; 
        backtrack(cost,position+1,res, steps);
        backtrack(cost,position+2,res,steps);
    }
}
