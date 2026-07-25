class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>(); 
        //int n = s.length();
        if(s.length()==0) return 0; 
        int res = 1; 
        int j=0;

        s=s.trim(); 
        int n = s.length();  
        for(int i=0;i<n;++i){
            char curr = s.charAt(i); 
            //res = Math.max(res, i-j); 
            while(j<n && set.contains(curr)){ 
                set.remove(s.charAt(j));  
                j++;
            }
                        set.add(curr) ;
            res = Math.max(res, i-j+1); 
        }

        return res; 
    }
}
