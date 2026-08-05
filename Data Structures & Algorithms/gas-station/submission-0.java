class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(sum(cost)>sum(gas)) return -1; 

        int tank =0; 
        int res = 0; 
        for(int i=0;i<gas.length;++i){
            tank += gas[i] - cost[i]; 

            if(tank<0){
                tank =0; 
                res = i+1; 
            }
        }
    return res; 
    }

    private static int sum(int[] x){
        int s =0; 
        for(int i : x){
            s+=i;
        }
        return s; 
    }
}
