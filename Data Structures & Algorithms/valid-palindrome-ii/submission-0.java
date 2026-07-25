class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length(); 
        for(int i=0; i<n/2; ++i){
            if(s.charAt(i) != s.charAt(n-i-1)){
                return isPal(s.substring(i+1,n-i)) || isPal(s.substring(i,n-i-1));
            }
        } 

        return true;        
    }

    private boolean isPal(String s){
        int n = s.length(); 
        for(int i=0;i<=n/2;++i){
         if(s.charAt(i) != s.charAt(n-i-1)){
            return false;
         }
        }

        return true; 
    }

}