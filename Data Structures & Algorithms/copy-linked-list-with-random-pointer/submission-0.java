/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        map.put(null,null); 
        Node itr = head; 
        Node newHead = new Node(0); 
        Node dummy = newHead; 
        while(itr != null){
            Node temp; 
            if(map.containsKey(itr)){
                temp = map.get(itr); 
            } else {
                temp = new Node(itr.val); 
                map.put(itr,temp); 
            }
            dummy.next = temp; 
            if(!map.containsKey(itr.random)){
                map.put(itr.random, new Node(itr.random.val)); 
            }
                dummy = dummy.next;
                dummy.random = map.get(itr.random);

            itr = itr.next;
        }
        return map.get(head); 
    }
}
