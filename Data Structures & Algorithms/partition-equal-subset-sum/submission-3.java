class Solution {
    public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum(); 

        if(target % 2 == 1) return false; 

        target/=2; 

        return dfs(nums, 0, target, 0); 
    }

    private boolean dfs(int[] nums, int i, int target, int sum){
        if(i==nums.length || sum>target) return false; 
        if(sum == target) return true; 

        //exclude
        boolean a = dfs(nums, i+1, target, sum); 
        // include 
        boolean b = dfs(nums, i+1, target, sum+nums[i]);

        return a||b; 

    }
}
