class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> 
            b.getValue() - a.getValue()); 
        HashMap<Integer,Integer> map = new HashMap<>(); 
        int n = nums.length; 

        // counting logic and store in hashmap 
        for(int i=0;i<n;++i){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);  
            } else {
                map.put(nums[i],1); 
            }
        }

        for(HashMap.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue())); 
        }
        int[] res = new int[k]; 
        while(k-- > 0){
            Pair<Integer,Integer> curr = pq.poll(); 
            res[k] = curr.getKey(); 
        }
        return res; 
    }
}
