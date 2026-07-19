class Solution {
    public void sortColors(int[] nums) {
        //  1 2 0
      //      l   r
        //      i

        int n = nums.length; 

        int l = 0; 
        int r = n-1; 
        int i=0;
        
        while(l<r && i<n){
            if(nums[i] == 0){
                swap(nums,i,l); 
                l++; 
                i++; 
            } else if(nums[i] == 2 && i<r){
                swap(nums, i, r);
                r--;  
            } else {
                i++; 
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a]; 
        nums[a] = nums[b]; 
        nums[b] = temp; 
    }
}