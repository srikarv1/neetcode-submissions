class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 1; 
        int minProduct = 1; 
        int res = maximum(nums); 
        int n = nums.length; 
        //[1,2,3,-4,0,5,-6]
        //[1,2,-3,4]
        // curr=1, min =-3, max =2
        for(int i=0;i<n;++i){
            int curr = nums[i]; 
            if(curr==0){
                minProduct = 1;
                maxProduct = 1;
                continue; 
            }
            int temp = maxProduct; 
            maxProduct = Math.max(temp * curr, Math.max(minProduct*curr, curr)); 
            minProduct = Math.min(temp * curr, Math.min(minProduct*curr, curr)); 
            
            res = Math.max(minProduct,Math.max(maxProduct,res)); 
        }
        return res; 
    }

    private static int maximum(int [] a){
        int maximum = Integer.MIN_VALUE;
        for(int x : a){
            if(x>maximum) maximum =x; 
        }
        return maximum; 
    }
    
}
