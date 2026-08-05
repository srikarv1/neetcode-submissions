class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    
    int n= nums.length; 
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0; i<n;++i){
    if(nums[i]>0) break;
    if (i > 0 && nums[i] == nums[i - 1]) continue;

    List<Integer> temp = twoSum(i+1, n-1, ((-1)*(nums[i])), nums, res);

    if(temp.size() ==0) continue; 
    }
        return res;
    }

    private List<Integer> twoSum(int l, int r, int target, int[] nums, List<List<Integer>> res){
        while(l<r && l>0 && r<nums.length){
            if(nums[l] + nums[r] == target){
              res.add(List.of(-1*target, nums[l],nums[r]));  
              l++;
              r--; 
            while (l < r && nums[l] == nums[l - 1]) {
                        l++;
            }
            }
            else if (nums[l] + nums[r] > target) {
                r--;
            }
            else l++;
        }
        return List.of(); 
    }
    
}
