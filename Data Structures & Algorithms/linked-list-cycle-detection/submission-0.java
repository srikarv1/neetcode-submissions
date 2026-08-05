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
    public boolean hasCycle(ListNode head) {
        ListNode i = head; 
        while(i != null){
            if(i.val > 1000)
            {
                return true;
            }
            else{
                i.val += 1000; 
            }
            i = i.next; 
        }
        return false; 
    }
}
