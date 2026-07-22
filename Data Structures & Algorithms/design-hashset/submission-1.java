    public class ListNode{
        int value; 
        ListNode next; 

        public ListNode(int value){
            this.value = value; 
            this.next = null; 
        }

        public ListNode(int value, ListNode next){
            this.value = value; 
            this.next = next; 
        }
    }

class MyHashSet {

    ListNode[] list; 
    public MyHashSet() {
        list = new ListNode[10000]; 

        for(int i=0; i<10000; ++i){
            list[i] = new ListNode(-1); 
        }
    }
    
    public void add(int key) {
        if(!contains(key)){
            ListNode search = list[key%10000]; 
            while(search.next !=null){
                search = search.next; 
            }
            search.next = new ListNode(key); 
        }
    }
    
    public void remove(int key) {
        if(contains(key)){
            ListNode prev = list[key%10000]; 
            while(prev.next.value != key){
                prev = prev.next; 
            }

            prev.next = prev.next.next; 
        }
    }
    
    public boolean contains(int key) {
         ListNode search = list[key%10000]; 
            while(search != null){
                if(search.value == key) return true; 
                search = search.next; 
            }

            return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */