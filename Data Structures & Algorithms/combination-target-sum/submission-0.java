class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> combination = new ArrayList<>(); 
        dfs(nums,target,res,combination,0);  

        return res;
    }

    private static void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> combination,int i){
        // add itself 
        // dont include itself 
        if(sum(combination)==target){
            res.add(new ArrayList<>(combination)); 
            return; 
        }

        if(sum(combination)>target || i>=nums.length) return; 
        
        combination.add(nums[i]);
        dfs(nums,target,res,combination,i);
        combination.remove(combination.size()-1);
        dfs(nums,target,res,combination,i+1);
    }

    private static int sum(List<Integer> a){
        int s =0; 
        for(int x : a){
            s+=x; 
        }
        return s; 
    } 
}
