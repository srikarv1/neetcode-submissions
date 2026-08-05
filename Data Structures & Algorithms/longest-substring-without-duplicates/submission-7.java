class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); 

        int i=0,j=0,n=s.length();

        int res =0; 

        while(j<n){
            if(set.contains(s.charAt(j))){
                while(i<j && s.charAt(i) != s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                } 
                i++;
            }

            set.add(s.charAt(j));

            if(set.size()>res) res=set.size();
            j++;
        }

        return res;
    }
}
