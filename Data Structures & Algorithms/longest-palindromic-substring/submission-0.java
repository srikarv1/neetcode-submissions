class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        int l = 0, r=0; 

        for(int i=0; i<n; ++i){
            l=i; r=i; 
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(r-l-1>res.length()) res=s.substring(l+1,r); 
             l=i; r= i+1; 
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(r-l-1>res.length()) res=s.substring(l+1,r); 
        }
        return res;
    }
}
