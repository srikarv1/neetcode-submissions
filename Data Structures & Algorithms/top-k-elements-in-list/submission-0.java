class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i,0) +1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            pq.offer(new int[]{m.getValue(), m.getKey()});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0;i<k;++i){
            result[i] = (pq.poll()[1]);
        }

        return result;
    }
}
