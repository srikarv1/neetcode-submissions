class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 1; 

        Set<String> set = new HashSet<>(); 
        for(String word:wordList) set.add(word); 

        if(!set.contains(endWord)) return 0; 

        Queue<String> q = new ArrayDeque<>(); 

        q.offer(beginWord); 

        while(!q.isEmpty()){
            int size = q.size(); 

            for(int x=0;x<size;++x){
                String curr = q.poll(); 
                for(int i=0;i<curr.length();++i){
                    char currChar = curr.charAt(i); 
                    StringBuilder sb = new StringBuilder(curr); 
                    for(int f=0;f<26;++f){
                        char a = (char)('a'+f); 
                        if(a==currChar) continue; 
                        sb.setCharAt(i,a); 
                        if(set.remove(sb.toString())){
                            if(sb.toString().equals(endWord)) return res+1; 
                            q.offer(sb.toString()); 
                        }
                    }
                }
            }
                    res++; 
        }
            return 0; 

}
}
