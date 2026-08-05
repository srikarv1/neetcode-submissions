class Solution {
    public int maxProfit(int[] prices) {
    int n = prices.length; 

    int start = prices[0];
    int res = 0;     
    for(int i=1;i<n;++i){
        if(prices[i]<start){
            start = prices[i]; 
        } else {
            res = Math.max(res, prices[i]-start);
        }
    }

    return res; 
    
    }
}
