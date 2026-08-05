class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>(); 
        Map<String, List<String>> map = new HashMap<>(); 


        for(String s : strs){
            char[] ch = s.toCharArray(); 
            Arrays.sort(ch); 
            String s1 = new String(ch);  

            if(map.containsKey(s1)){
                map.get(s1).add(s); 
            } else {
                List<String> temp = new ArrayList<>(); 
                temp.add(s); 
                map.put(s1,temp); 
            }
        }

        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            List<String> temp = entry.getValue(); 
            res.add(temp); 
        }

        return res; 
    }
}
