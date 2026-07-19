class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for(int num : nums){
            if(map.containsKey(num)){
                int temp = map.get(num); 
                map.put(num,temp+1); 
            } else {
                map.put(num,1); 
            }
        }

        PriorityQueue<Pair<Integer,Integer>> pq = 
        new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        ); 

        for(int x : map.keySet()){
            pq.offer(new Pair(x, map.get(x))); 
            if(pq.size() >k){
                pq.poll(); 
            }
        }

        int[] res = new int[pq.size()]; 
        while(!pq.isEmpty()){
            res[--k] = pq.poll().getKey(); 
        }

        return res; 
    }
}
