class Solution {
    HashMap<String,List<String>> graph; 
    Set<String> visited; 
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        graph = new HashMap<>(); 
        visited = new HashSet<>(); 
        int res =0; 
        int n = beginWord.length(); 

        for(String s: wordList){
            for(int i=0;i<s.length();++i){
                StringBuilder sb = new StringBuilder(s); 
                sb.setCharAt(i,'*');
                if(graph.containsKey(sb.toString())){
                    graph.get(sb.toString()).add(s); 
                }
                else{
                    List<String> temp = new ArrayList<>(); 
                    temp.add(s); 
                    graph.put(sb.toString(),temp); 
                }
            }
        }

        Queue<Pair<String,Integer>> q = new LinkedList<>(); 

        q.add(new Pair(beginWord,1)); 

        while(!q.isEmpty()){
            Pair<String,Integer> currPair = q.poll();
            String currString = currPair.getKey(); 
            for(int i=0;i<n;++i){
                StringBuilder sb = new StringBuilder(currString);
                sb.setCharAt(i,'*');
                if(graph.containsKey(sb.toString())){
                    for(String x : graph.get(sb.toString())){
                        if(visited.contains(x)) continue; 
                        if(x.equals(endWord)){
                            return currPair.getValue()+1; 
                        }
                        else{
                            q.offer(new Pair(x,currPair.getValue()+1)); 
                            visited.add(x); 
                        }
                    }
                }
            }
        }

        return 0;
    }
}
