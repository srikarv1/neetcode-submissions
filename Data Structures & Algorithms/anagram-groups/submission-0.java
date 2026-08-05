class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            int[] keyArray = new int[26];
            for(int i=0;i<str.length();++i){
                keyArray[str.charAt(i)-'a']++;
            }
            String key = Arrays.toString(keyArray);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
}
}
