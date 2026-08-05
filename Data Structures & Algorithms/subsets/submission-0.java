class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(res,nums,0,subset);

        return res; 
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, int i, List<Integer> subset){
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return; 
        }
        subset.add(nums[i]);
        backtrack(res,nums,i+1,subset);
        subset.remove(subset.size()-1);
        backtrack(res,nums,i+1,subset);

    }
}
