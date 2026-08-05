class Solution {
    public int change(int amount, int[] coins) {
        HashMap<State,Integer> map = new HashMap<>(); 
        // state key stores index and corresponding amount left - the value stores the number of ways
        return dfs(coins,0,amount,map);
    }

    private static int dfs(int[] coins, int i, int amount, HashMap<State,Integer> map){
        if(i>=coins.length || amount < 0) return 0;
        if(amount == 0) return 1;   
        State key = new State(i,amount);
        if(map.containsKey(key)) return map.get(key); 
        int include = dfs(coins,i,amount-coins[i],map); 
        int exclude = dfs(coins,i+1,amount,map);
        map.put(key, include+exclude); 
        return include+exclude; 
    }

    static class State{
        int index; 
        int amount; 

        State(int index, int amount){
            this.index = index; 
            this.amount = amount; 
        }
        @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof State)) return false;
    State state = (State) o;
    return index == state.index && amount == state.amount;
}

@Override
public int hashCode() {
    return Objects.hash(index, amount);
}
    }
}
