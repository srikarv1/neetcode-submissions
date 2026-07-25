class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0; 
        int n = prices.length;
        int curr = prices[0]; 
        for(int i=1;i<n;++i){
            if(prices[i] >= curr){
                profit = Math.max(prices[i]-curr, profit);
            } else {
                curr = prices[i]; 
            }
        }

        return profit; 
    }
}
