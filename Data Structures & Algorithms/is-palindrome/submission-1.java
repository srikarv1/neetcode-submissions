class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length(); 
        
        int j = n-1; 
        for(int i=0;i<n && i<=j;++i){
            if(Character.isLetterOrDigit(s.charAt(i))){
                while(!Character.isLetterOrDigit(s.charAt(j))) j--; 
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false; 
                j--;
            }
        }

        return true; 
    }
}
