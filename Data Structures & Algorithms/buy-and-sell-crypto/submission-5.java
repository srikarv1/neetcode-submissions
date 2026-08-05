class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length; 

        int l=0; 
        int r = l+1;

        int maxProfit = 0;
        while(r<n & l<r){
            int temp = prices[r] - prices[l]; 
            if(temp>maxProfit) maxProfit = temp; 
            if(temp<=0){
                l=r;
                r++;
            }

            if(temp>0){
            r++;
            }
        }

        return maxProfit; 
    }
}
