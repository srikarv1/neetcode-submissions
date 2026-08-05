class Solution {
    public int climbStairs(int n) {
        // lets use backtracking 
        int[] res = new int[1]; 
        int sum=0;
        backtrack(res,n,0);

        return res[0];
    }

    private static void backtrack(int[] res, int target, int sum){
        if(sum>target) return; 
        if(sum == target) res[0]++;

        backtrack(res,target,sum+1); 
        backtrack(res,target,sum+2); 
    }
}
