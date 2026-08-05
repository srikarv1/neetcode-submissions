/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    
    ListNode ptr = head; 
    int size = 0;
    while(ptr!=null){
        size++;
        ptr = ptr.next;
    }
    if(size ==1) return null; 
    if(size == n) return head.next; 
    int stopAt = size - n; 
    ListNode prev = null; 
    ListNode h = head; 
    while(h != null && stopAt != 0){
        if(stopAt == 1)
        {
            prev = h; 
        }
        h = h.next; 
        stopAt--; 
    }
    prev.next = h.next; 
    h.next = null; 
    return head;
    }
}
