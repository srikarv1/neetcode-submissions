class Solution {
    public String minWindow(String s, String t) {
    HashMap<Character,Integer> map = new HashMap<>(); 
    Set<Character> set = new HashSet<>(); 
    for(Character c : t.toCharArray()){
        set.add(c);
        if(map.containsKey(c)){
            map.put(c, map.get(c) + 1);        
        }
        else{
            map.put(c,1);
        }
    }

    int i=0,j=0;
    int n = s.length();
    int res = Integer.MAX_VALUE;
    int index1 = -1, index2 =0; 
    int count =t.length();  
    while(j<n){
        if(map.containsKey(s.charAt(j))){
            int temp = map.get(s.charAt(j));
            map.put(s.charAt(j), temp-1);
            if(temp>0) count--;
        }
        else{
            map.put(s.charAt(j),-1);
        }

           while (count == 0) {
                // Update result if smaller window found
                int window = j - i + 1;
                if (window < res) {
                    res = window;
                    index1 = i;
                    index2 = j + 1; 
                }

                char left = s.charAt(i);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) > 0) count++;
                }
                i++;
            }
        j++;
    }
    if(index1 == -1) return "";
    return s.substring(index1,index2); 
    }
}
