class StockSpanner {
    Stack<int[]> stack; 
    public StockSpanner() {
        stack = new Stack<>(); 
        // [x,y] x = price, y = span 
    }
    
    public int next(int price) {
        if(stack.isEmpty() 
        || stack.peek()[0] > price){
            stack.push(new int[]{price, 1}); 
            return 1; 
        } else {
            int span = 0; 
            while(!stack.isEmpty() && 
            stack.peek()[0] <= price){
                span += stack.pop()[1]; 
            }

            stack.push(new int[]{price,span+1}); 
            return span+1; 
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */