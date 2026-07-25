class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0; 

        int prev = prices[0];
        int idx =0; 
        int bought = prices[0]; 
        for(int i=1;i<prices.length;++i){
            if(prices[i] < prices[i-1]){
                profit += prices[i-1] - prev;   
                prev = prices[i];  
                idx =i;             
            } 
        }

        if(prices.length != idx+1){
            profit += prices[prices.length-1]-prev;
        }

        return profit; 
    }
}