class Solution {
    public int[] productExceptSelf(int[] nums) {
        // so the idea is to 

        /*
             0.  1  2. 3  4
            [-1, 0, 1, 2, 3]


            the idea for any particular index would be to get the products from left and right except it 

            [1 -1 0 0 0]
            [0   6  6  3  1 ]

            [0 -6 0 0 0]

        
            cummulative 
        */
        
        int n = nums.length; 
        int[] prefix = new int[n]; 
        int[] suffix = new int[n]; 

        prefix[0]=1; 
        for(int i=1;i<n;++i){
            prefix[i] = prefix[i-1] * nums[i-1]; 
        }

        suffix[n-1]=1; 
        for(int i=n-2;i>=0;--i){
            suffix[i] = suffix[i+1] * nums[i+1]; 
        }

        int[] res = new int[n]; 

        for(int i=0;i<n;++i){
            res[i] = prefix[i] * suffix[i]; 
        }

        return res; 

    }
}  
