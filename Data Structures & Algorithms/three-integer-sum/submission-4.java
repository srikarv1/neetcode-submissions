class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        

        /*
            a + b + c = 0 
            a = -(b+c)

            so ideally, fix a (n times)
            find b and c using left right pointers (n again) - we need to sort array (nlogn)
            to battle distinct chars move i and j completely by checking prev k will 
            automatically be handled 

        */

        int i=0;
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); 
        while(i<n){
            int j = i+1; 
            int k = n-1; 
            int target = -1 * nums[i]; 
            while(j<k){
                if(nums[j] + nums[k] == target){
                    res.add(List.of(nums[i],nums[j],nums[k])); 
                    while(j<n-1 && nums[j+1]==nums[j]) j++; 
                    j++; 
                } else if(nums[j]+nums[k]>target){
                    k--;
                } else {
                    j++; 
                }
            }

            while(i<n-1 && nums[i+1]==nums[i])i++; 
            i++; 
        }

        return res; 
        
    }
}
