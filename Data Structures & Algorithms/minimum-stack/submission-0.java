class MinStack {
    List<int[]> stack; 
    public MinStack() {
        stack = new ArrayList<>(); 
        // int[] -> val , min 
        stack.add(new int[]{0,Integer.MAX_VALUE});
    }
    
    public void push(int val) {
        if(val<stack.get(stack.size()-1)[1]){
            stack.add(new int[]{val,val}); 
        } else {
            stack.add(new int[]{val,stack.get(stack.size()-1)[1]}); 
        }
    }
    
    public void pop() {
        stack.remove(stack.size()-1); 
    }
    
    public int top() {
        return stack.get(stack.size()-1)[0]; 
    }
    
    public int getMin() {
        return stack.get(stack.size()-1)[1]; 
    }
}
