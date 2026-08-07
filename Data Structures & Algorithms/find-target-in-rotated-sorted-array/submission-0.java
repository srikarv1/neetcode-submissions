class Solution {
    public int search(int[] nums, int target) {
        // [3, 4, 5, 6, 1, 2]

        int l=0; 
        int r= nums.length-1; 

        while(l<r){
            int m = l + ((r-l)/2); 
            if(nums[m]>nums[r]){
                l = m + 1;
            } else {
                r =m; 
            }
        }
        int pivot = l; 

        if(nums[pivot] <= target && nums[nums.length-1] >= target){
            return binarySearch(nums,pivot,nums.length-1,target);
        } else {
            return binarySearch(nums,0,pivot-1,target); 
        }
    }

    private int binarySearch(int[] nums, int l, int r, int target){
        while(l<=r){
            int m = l + ((r-l)/2); 
            if(nums[m] == target) return m; 
            else if(nums[m] > target){
                r = m -1; 
            }
            else l = m+1; 
        }
        return -1; 
    }
}
