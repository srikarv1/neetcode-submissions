class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // find k so essentially brute force it (binary search)


        Arrays.sort(piles); 
        int n = piles.length; 
        int l = 1; 
        int r = piles[n-1]; 

        int res = Integer.MAX_VALUE; 
        while(l<=r){
            int k = l + ((r-l)/2); 

            if(possible(piles,k,h)){
                res = Math.min(res,k); 
                r = k-1;
            } else {
                l = k+1; 
            }
        }
        return res; 
    }

    private boolean possible(int[] piles, int k, int h){
        int n = piles.length; 
        long totalHours = 0; 
        for(int i=0;i<n;++i){
            totalHours+= Math.ceil((double)piles[i]/k); 
            if(totalHours>h) return false; 
        }

        return true; 
    }
}
