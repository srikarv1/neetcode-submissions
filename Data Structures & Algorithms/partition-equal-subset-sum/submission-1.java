class Solution {
    public boolean canPartition(int[] nums) {
        // take the whole sum 
        // pick a subset that gives us sum/2 --> 
        int target =0; 
        for(int x : nums){
            target+=x; 
        } 
        if(target%2==1) return false;
        target /= 2; 

        Set<Integer>  set= new HashSet<>();
        // now pick elements that add up to target
        // make sure its not full array
        return dfs(nums,target,0,0,set);
    }

    private static boolean dfs(int[] nums, int target,int sum, int index, Set<Integer> set){
        if(sum==target && index!=nums.length) return true; 
        if(sum>target || index>=nums.length) return false; 
        boolean exclude = dfs(nums,target,sum,index+1, set); 
        set.add(sum+nums[index]);
        boolean include = dfs(nums,target,sum+nums[index], index+1, set);

        return include || exclude;
        
    }
}
