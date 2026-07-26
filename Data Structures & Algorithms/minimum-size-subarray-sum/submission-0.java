class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0; 

        int res = Integer.MAX_VALUE; 
        int n = nums.length; 
        int j=0; 
        for(int i=0;i<n;++i){
            sum+=nums[i]; 

            while(sum>=target){
                res = Math.min(res, i-j+1); 
                sum -= nums[j]; 
                j++; 
            }
        }

        if(res == Integer.MAX_VALUE) return 0; 
        return res; 
    }
}