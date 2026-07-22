class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int x:nums){
            set.add(x); 
        }

        int res =0; 
        for(int i=0;i<nums.length;++i){
            if(!set.contains(nums[i]-1)){
                int count = 1; 
                int dummy = nums[i]+1; 
                while(set.contains(dummy)){
                    count++; 
                    dummy++; 
                }
                res = Math.max(res,count); 
            }
        } 

        return res; 
    }
}
