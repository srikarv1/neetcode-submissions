class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int n = nums.length; 
        for(int i=0; i<n; ++i){
            set.add(nums[i]);
        }

        Iterator<Integer> itr = set.iterator(); 

        int res =0; 
        while(itr.hasNext()){
            int num = itr.next(); 
            int count=1; 

            if(set.contains(num-1)) continue; 
            else{
                while(true){
                    if(set.contains(num+1)){
                        count++;
                        num++;
                    }
                    else{
                        break; 
                    }
                }
            }
            if(count>res) res=count; 
        }

        return res; 
    }
}
