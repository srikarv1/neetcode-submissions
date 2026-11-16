class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]); 
        Map<Integer, List<int[]>> map = new HashMap<>(); 
        for(int[] time : times){
            if(!map.containsKey(time[0])){
                List<int[]> tmp = new ArrayList<>(); 
                tmp.add(new int[]{time[1],time[2]}); 
                map.put(time[0],tmp); 
            } else {
                map.get(time[0]).add(new int[]{time[1], time[2]}); 
            }
        }

        pq.offer(new int[]{0,k}); 

        Set<Integer> visited = new HashSet<>(); 
       // visited.add(k); 
        int res = 0; 
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll(); 
            int w1 = curr[0]; 
            int n1 = curr[1]; 

            if(visited.contains(n1)) continue; 
            visited.add(n1); 
            res = w1; 

            if(map.containsKey(n1)){
                for(int[] next : map.get(n1)){
                    int w2 = next[1]; 
                    int n2 = next[0]; 
                    if(!visited.contains(n2)){
                        pq.offer(new int[]{w1+w2,n2}); 
                    }
                }
            }
        }

        return visited.size() == n ? res:-1; 
    }
}
