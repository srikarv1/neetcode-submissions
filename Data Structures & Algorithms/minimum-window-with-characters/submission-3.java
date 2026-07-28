class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> required = new HashMap<>(); 


        // store reqd dict 
        for(int i=0;i<t.length();++i){
            if(required.containsKey(t.charAt(i))){
                int temp = required.get(t.charAt(i)); 
                required.put(t.charAt(i),temp+1);
            } else {
                required.put(t.charAt(i),1); 
            }
        }

        HashMap<Character,Integer> window = new HashMap<>(); 

        int j =0; 
        int found = 0; 
        String res = ""; 
        int resLen = Integer.MAX_VALUE; 
        for(int i=0;i<s.length();++i){
            char curr = s.charAt(i); 

            if(window.containsKey(curr)){
                int temp = window.get(curr); 
                window.put(curr,temp+1); 
            } else {
                window.put(curr,1); 
            }

            if(required.containsKey(curr) && window.get(curr) == required.get(curr)){
                found++; 
            }

            while(found == required.size()){
                char leftChar = s.charAt(j); 
                int temp = window.get(leftChar); 
                window.put(leftChar, temp-1);


                if(i-j < resLen){
                res = s.substring(j,i+1); 
                resLen = i-j+1;  
                }

                
            if(required.containsKey(leftChar) && window.get(leftChar) < required.get(leftChar)){
                found--; 
            }
            j++; 
            }
        }


        return res; 
    }
}
