class FreqStack {
    HashMap<Integer, Integer> numToCount; 
    TreeMap<Integer, List<Integer>> countToNums;
    public FreqStack() {
        numToCount = new HashMap<>(); 
        countToNums = new TreeMap<>(); 
    }
    
    public void push(int val) {
        numToCount.put(val, numToCount.getOrDefault(val,0)+1); 
        int currCount = numToCount.get(val); 

        if(countToNums.containsKey(currCount)){
            countToNums.get(currCount).add(val); 
        } else {
            List<Integer> temp = new ArrayList<>(); 
            temp.add(val); 
            countToNums.put(currCount,temp); 
        }
    }
    
    public int pop() {
        List<Integer> popper = countToNums.get(countToNums.lastKey()); 
        int val = popper.get(popper.size()-1); 
        popper.remove(popper.size()-1); 

        if(popper.size() == 0){
            countToNums.remove(countToNums.lastKey());
        }
        numToCount.put(val, numToCount.get(val)-1); 

        if(numToCount.get(val) == 0){
            numToCount.remove(val); 
        }

        return val; 
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */