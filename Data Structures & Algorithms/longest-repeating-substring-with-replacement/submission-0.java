class Solution {
    public int characterReplacement(String s, int k) {
        int i=0, j =0; 
        int n = s.length();
        int[] alphabets = new int[26];
        int res =0;
        while(j<n){
            int window = j-i+1;
            alphabets[s.charAt(j)-'A']++;
            if(window - maximum(alphabets) > k){
                alphabets[s.charAt(i) - 'A']--;
                i++;
            }
            else {
                if(window > res) res=window; 
            }
                j++;
        }
        return res;
    }

    private static int maximum(int[] a){
        int max =0;
        for(int i=0;i<26;++i){
            if(a[i]>max) max = a[i];
        }
        return max; 
    }
}
