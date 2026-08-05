class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<State,Integer> cache = new HashMap<>(); 
        return dfs(nums,0,target,cache);    
    }

    private static int dfs(int[] nums, int i, int target, HashMap<State,Integer> cache){
        if(i>=nums.length && target!=0) return 0; 
        if(i==nums.length && target ==0) return 1; 
        return dfs(nums,i+1,target-nums[i],cache)+dfs(nums,i+1,target+nums[i],cache); 
    }


    static class State{
        int index; 
        int amount; 

        State(int index, int target){
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
