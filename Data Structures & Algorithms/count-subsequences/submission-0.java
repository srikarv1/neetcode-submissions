class Solution {
    public int numDistinct(String s, String t) {
        // generate all subsequences and check if equal to 't'. 
        StringBuilder sb = new StringBuilder(); 
        int[] res = new int[1]; 
        dfs(s,t,sb,0,res);

        return res[0];
    }

    private static void dfs(String s, String t, StringBuilder sb, int i, int[] res){
        if(sb.length() == t.length()){
            res[0]+= isEqual(sb.toString(),t) ? 1:0; 
            return; 
        }
        if(i>=s.length()) return; 


        sb.append(s.charAt(i)); 
        dfs(s,t,new StringBuilder(sb),i+1,res);
        sb.deleteCharAt(sb.length()-1); 
        dfs(s,t,new StringBuilder(sb),i+1,res); 
    }

    private static boolean isEqual(String s, String t){
        int len = s.length(); 
        for(int i=0;i<len;++i){
            if(s.charAt(i)!=t.charAt(i)) return false;
        }
        return true; 
    }
}
