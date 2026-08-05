class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(); 
        int n = wordDict.size();
        for(int i=0; i<n; ++i){
            set.add(wordDict.get(i)); 
        }
        // initialized a set to contain dictionary words 
        // move recursively and explore possibilities if i>n thats ur base condition 
        boolean[] res = new boolean[1]; 
        res[0] = false; 
        Set<String> found = new HashSet<>(); 

        dfs(s,set,res,0,found); 

        return res[0]; 
    }

    private static void dfs(String s, Set<String> set, boolean[] res, int start, Set<String> found){
        if(start >= s.length()){
            res[0] = true; 
            return; 
        }
        if(found.contains(s.substring(start,s.length()))) return; 
        for(int i=start; i<s.length();++i){
            if(set.contains(s.substring(start,i+1))) dfs(s,set,res,i+1, found);
        }
        found.add(s.substring(start,s.length()));
        return; 
    }
}