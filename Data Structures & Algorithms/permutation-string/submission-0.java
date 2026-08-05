class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //make character array for s1 
        //use s2 sliding window to match that array 
        // window is of constant size 
        if(s2.length() < s1.length()) return false; 
        int[] fixed = new int[26];
        int n = s2.length();
        int[] checker = new int[26];

        for(int i=0;i<s1.length();++i){
            fixed[s1.charAt(i)-'a']++;
            checker[s2.charAt(i)-'a']++;
        }

               if (valid(fixed, checker)) return true;

        for (int r = s1.length(); r < s2.length(); ++r) {
            checker[s2.charAt(r) - 'a']++;
            checker[s2.charAt(r - s1.length()) - 'a']--;
            if (valid(fixed, checker)) return true;
        }

        return false;
    }
    
    private static boolean valid(int[] a, int[] b){
        for(int i=0;i<26;++i){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
