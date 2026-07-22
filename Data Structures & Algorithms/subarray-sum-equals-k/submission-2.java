class Solution {
    public int subarraySum(int[] nums, int k) {
        // [ 2 -1 1 2]
        // [ 2  1 2 4]

        // store all sums in a map -- hold count everytime it is encountered

        // prefix[j] - prefix[i] = k
        int res = 0;

        HashMap<Integer,Integer> map = new HashMap<>(); 
        int[] prefix = new int[nums.length]; 
        prefix[0] = nums[0]; 
        for(int i=1; i<nums.length; ++i){
           // if(map.containsKey(k))
            prefix[i] = prefix[i-1] + nums[i]; 
        }

        map.put(0,1); 
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(prefix[i] - k)){
                res += map.get(prefix[i] - k); 
            } 

            if(map.containsKey(prefix[i])){
                int tmp = map.get(prefix[i]); 
                map.put(prefix[i],tmp+1); 
            } else {
                map.put(prefix[i],1); 
            }
        }

        return res; 
    }
}