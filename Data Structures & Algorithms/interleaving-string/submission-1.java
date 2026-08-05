class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m+n != s3.length()) return false; 

        return dfs(s1,s2,s3,0,0);
    }

    private static boolean dfs(String s1,String s2,String s3,int i,int j){
        int k=i+j; 
        if(k>=s3.length()) return true; 
        if(i<s1.length() && j< s2.length() && s1.charAt(i) == s2.charAt(j) && s1.charAt(i)==s3.charAt(k)){
            return dfs(s1,s2,s3,i+1,j) ||
            dfs(s1,s2,s3,i,j+1);
        }
        else if(i<s1.length() && s1.charAt(i) == s3.charAt(k)) return dfs(s1,s2,s3,i+1,j);
        else if(j<s2.length() && s2.charAt(j)== s3.charAt(k)) return dfs(s1,s2,s3,i,j+1);
        return false;
    }
}
