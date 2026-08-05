class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return List.of(); 
        Map<Character,String> map = new HashMap<>(); 
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> res = new ArrayList<>(); 
        StringBuilder sb = new StringBuilder(); 

        backtrack(digits,map,res,sb,0);

        return res; 
    }

    private static void backtrack(String digits, Map<Character,String> map, List<String> res, StringBuilder sb, int index){
        if(index == digits.length()){
            res.add(new StringBuilder(sb).toString());
            return; 
        }
            String possibilities = map.get(digits.charAt(index)); 
            for(char s : possibilities.toCharArray()){
                sb.append(s);
                backtrack(digits,map,res,sb,index+1);
                sb.deleteCharAt(sb.length() - 1);
            }
        
    }
}
