class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>(); 
        List<String> partition = new ArrayList<>();   
        backtrack(s,partition,res,0);

        return res; 
    }
  
    private static void backtrack(String s, List<String> partition,List<List<String>> res, int start){
        if(start == s.length()){
            res.add(new ArrayList<>(partition));
            return;
        }         
        for(int end = start+1; end<=s.length(); ++end){
            if(isPalindrome(s.substring(start,end))){
                partition.add(s.substring(start,end));
                backtrack(s,partition,res,end);
                partition.remove(partition.size()-1);
            }
        }
        }

    private static boolean isPalindrome(String s){
        if(s.length()==1) return true; 
        for(int i=0,j=s.length()-1; i<s.length() && j>=0; i++, j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true; 
    }
}
