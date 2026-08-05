class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int val = Math.abs(nums[i]);
            if (nums[val] < 0) {
                return val;
            }
            nums[val] *= -1;
        }
        return -1; // will not be reached as per problem constraints
    }
}