class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length; 
        int s = 0; 
        for(int x:nums) s+=x; 
        return  (n*(n+1)/2)-s; 
    }
}
