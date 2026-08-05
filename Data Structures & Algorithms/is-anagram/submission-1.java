class Solution {
    public boolean isAnagram(String s, String t) {
        int[] bucket = new int[26]; 

        int n1 = s.length(); 
        int n2 = t.length(); 

        if(n1 != n2) return false; 

        for(int i = 0; i<n1; ++i){
            bucket[s.charAt(i) - 'a']++;  
        }

        for(int i=0;i<n2; ++i){
            bucket[t.charAt(i) - 'a']--;
        }

        for(int i=0;i<26;++i){
            if(bucket[i]!=0) return false;
        }

        return true; 
    }
}
