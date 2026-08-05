class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        int l = 0, r=0; 

        for(int i=0; i<n; ++i){
            l=i; r=i; 
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                res++;
            }
             l=i; r= i+1; 
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                res++;
            }
        }
        return res;
    }
}