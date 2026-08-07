class TimeValue{
    int timestamp; 
    String value;

    public TimeValue(int timestamp, String value){
        this.timestamp = timestamp; 
        this.value = value; 
    } 

}
class TimeMap {
    
    HashMap<String,List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new TimeValue(timestamp,value)); 
        } else {
            List<TimeValue> temp = new ArrayList<>(); 
            temp.add(new TimeValue(timestamp,value)); 
            map.put(key,temp); 
        }
    }
    
    public String get(String key, int timestamp) {
        String res = ""; 

        if(map.containsKey(key)){
            List<TimeValue> times = map.get(key); 
            int l = 0; 
            int r = times.size() - 1; 

            if(times.get(0).timestamp > timestamp) return ""; 
            while(l<=r){
                int m = l + ((r-l)/2); 
                TimeValue curr = times.get(m); 

                if(curr.timestamp == timestamp){
                    res = curr.value; 
                    break; 
                } else if( curr.timestamp < timestamp){
                    //l = m+1;
                    res = curr.value;   
                    l=m+1;
                } else r = m-1; 
            }

            //res = times.get(l).value; 
            
        }

        return res; 
    }
}
