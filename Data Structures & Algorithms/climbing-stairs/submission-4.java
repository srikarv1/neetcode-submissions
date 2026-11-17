class Solution {
    public int climbStairs(int n) {
        //int[] dp = new int[n+1]; 
        int n1 = 1; 
        int n2 = 1; 
        int res = 0;
        if(n==0 || n==1) return 1;  
        for(int i=2;i<=n;++i)
        {
            res = n1+n2; 
            n1 = n2; 
            n2 = res; 
        }        
        return res; 
    }
}
