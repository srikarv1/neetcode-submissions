class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        int[] lis = new int[n]; 
        Arrays.fill(lis,1);
        for(int i=n-2;i>=0;--i){
            for(int j=i+1; j<n ; ++j){
                if(nums[j]>nums[i]){
                    lis[i] = Math.max(lis[i],1+lis[j]);
                }
            }
        }
        int max = 0;
        for(int x:lis){
            max = Math.max(x,max); 
        }
        return max; 
    }
}
