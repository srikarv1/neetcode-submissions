class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int r = Arrays.stream(weights).sum();  
        int l = 1; 

        int res = Integer.MAX_VALUE;
        while(l<=r){
            int m = l + ((r-l)/2); 
            if(helper(weights,days,m)){
                r = m-1; 
                res=Math.min(res,m); 
            } else {
                l = m+1;
            }
        }

        return res; 
    }

    private boolean helper(int[] weights, int days, int cap){
        int count = 1; 
        int sum = 0; 

        for(int i=0;i<weights.length; ++i){
            if(weights[i] > cap) return false; 
            sum += weights[i]; 

            if(sum > cap){
                count ++; 
                sum = weights[i]; 
            } 
        }

        if(count > days) return false; 
        return true; 
    }
}