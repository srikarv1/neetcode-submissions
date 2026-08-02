class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>(); 

        for(String token : tokens){
            String value; 
            if(token.equals("+")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                value = String.valueOf(a+b); 
            } 

            else if(token.equals("-")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                value = String.valueOf(b-a); 
            }

            else if(token.equals("/")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                value = String.valueOf(b/a); 
            }

            else if(token.equals("*")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                value = String.valueOf(a*b); 
            } else {
                value = token; 
            }
            stack.push(value); 
        }

        return Integer.parseInt(stack.pop()); 
    }
}
