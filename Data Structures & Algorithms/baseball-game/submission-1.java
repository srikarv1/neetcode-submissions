class Solution {
    public int calPoints(String[] operations) {
        int res = 0; 

        Stack<String> stack = new Stack<>(); 

        for(String s : operations){
            if (s.equals("+")) {
    int a = Integer.parseInt(stack.pop());
    int b = Integer.parseInt(stack.pop());
    stack.push(String.valueOf(b));
    stack.push(String.valueOf(a));
    stack.push(String.valueOf(a + b));
}else if(s.equals("C")){
                stack.pop(); 
            } else if(s.equals("D")){
                //int a = stack.pop(); 

                int a = Integer.parseInt(stack.peek()); 
                stack.push(String.valueOf(2*a)); 
            } else {
                stack.push(s); 
            }
        }

        while(!stack.isEmpty()){
            res += Integer.valueOf(stack.pop()); 
        }

        return res; 
    }
}