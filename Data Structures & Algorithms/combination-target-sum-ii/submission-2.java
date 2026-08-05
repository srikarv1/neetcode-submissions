class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> subset = new ArrayList<>(); 
        Arrays.sort(candidates);
        dfs(0,res,subset,target,candidates); 
        return res;
    }

    private static void dfs(int i, List<List<Integer>> res, List<Integer> subset, int target, int[] nums){
        if(i>=nums.length){
            if(sum(subset) == target)
                res.add(new ArrayList<>(subset));
            return; 
        }
        subset.add(nums[i]);
        dfs(i+1,res,subset,target,nums);
        subset.remove(subset.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]) i++;
        dfs(i+1,res,subset,target,nums);
    }

    private static int sum(List<Integer> a){
        int s =0; 
        for(int x : a){
            s += x; 
        }
        return s; 
    }
}
