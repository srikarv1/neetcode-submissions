class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> subset = new ArrayList<>(); 

        backtrack(nums, subset,res,0); 

        return res; 
    }

    private static void backtrack(int[] nums, List<Integer> subset, List<List<Integer>> res, int i){
        if(i>=nums.length){
            res.add(new ArrayList<>(subset)); 
            return; 
        }
        subset.add(nums[i]); 
        backtrack(nums,subset,res,i+1); 
        subset.remove(subset.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]) i++;
        backtrack(nums,subset,res,i+1); 
    }
}
