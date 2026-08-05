class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1) return nums; 
        
        int l = 0; 
        int r = nums.length; 
        return merge(nums);
    }

    private int[] merge(int[] nums){
        if(nums.length <= 1){
            return nums; 
        }

        int mid = nums.length / 2; 
        int[] left = merge(Arrays.copyOfRange(nums, 0, mid)); 
        int[] right = merge(Arrays.copyOfRange(nums, mid, nums.length)); 

        int[] res = mergeArrays(left,right); 
        return res; 
    }

    private int[] mergeArrays(int[] left, int[] right){
        int i=0;
        int j=0;

        int[] res = new int[left.length + right.length]; 
        int k=0; 
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                res[k++] = left[i]; 
                i++; 
            } else {
                res[k++] = right[j]; 
                j++; 
            }
        } 

        while(i<left.length){
            res[k++] = left[i]; 
            i++; 
        }

        while(j<right.length){
            res[k++] = right[j]; 
            j++; 
        }

        return res; 
    }
}