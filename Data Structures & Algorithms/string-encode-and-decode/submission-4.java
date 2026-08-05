class Solution {

    public String encode(List<String> strs) {
        // represent start by * 
        // length of string first 

        StringBuilder res = new StringBuilder();

        for(String str: strs){
            res.append(str.length()).append('*').append(str);
        }
        return res.toString(); 
    }

    public List<String> decode(String str) {
        int i =0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
        int j=i;
        while(str.charAt(j) != '*'){
            j++;
        }
        int len = Integer.parseInt(str.substring(i,j));
        res.add(str.substring(j+1, j+1+len));
        i = j+1+len;
        }
        return res; 
    }
}
