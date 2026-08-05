class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Arrays.sort(hand); 
        for(int i=0;i<hand.length;++i){
            if(map.containsKey(hand[i])){
                map.get(hand[i]).add(i)  ;
            }
            else{
                List<Integer> temp = new ArrayList<>(); 
                temp.add(i); 
                map.put(hand[i],temp); 
            }
        }


        int i =0;
        int n = hand.length;  
        while(i<n){
        if(hand[i] == -1){
            i++;
            continue; 
        } 
        int start = hand[i]; 
        int j = groupSize; 
        while(j!=0){
            if(!map.containsKey(start)) return false; 
            else{
                int index = map.get(start).get(0);
                hand[index]=-1;  
                map.get(start).remove(0); 
                if(map.get(start).size()==0){
                    map.remove(start);
                }
            }
            start++;
            j--;
        }
        i++;
        }
        return true; 
    }
}
