class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>(); 

        int n = s.length();
        for(int i=0;i<n;++i){
            char curr = s.charAt(i); 

            if(curr!=']'){
                stack.push(String.valueOf(curr)); 
            } else {
                String temp = ""; 
                while(!stack.isEmpty() && !stack.peek().equals(String.valueOf('['))){
                    temp = stack.pop()+temp; 
                }
                stack.pop(); 

                String k = ""; 
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    k = stack.pop()+k; 
                }
                stack.push(temp.repeat(Integer.parseInt(k))); 
            }
        }

        String res = ""; 

        while(!stack.isEmpty()){
            res = stack.pop()+ res;
            //stack.pop();
        }

        return res; 
    }
}




