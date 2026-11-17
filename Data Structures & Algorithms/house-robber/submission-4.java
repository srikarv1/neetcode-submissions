class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        //int[] dp = new int[n];
        if(n==1) return nums[0]; 
        int p1 = nums[0]; 
        int p2 = Math.max(nums[0],nums[1]); 
        int curr = Math.max(p1,p2); 
        for(int i=2;i<n;++i){
            curr = Math.max(p2, nums[i]+p1);

            p1 = p2; 
            p2=curr;  
        } 
// 2 1 1 2 
// 2 1 3 
        return Math.max(curr,p2); 
    }
}
