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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head; 

        while(fast!=null && fast.next!=null){
            slow = slow.next; 
            fast = fast.next.next; 
        } 

        ListNode curr = slow.next; 
        
        slow.next = null; 

        ListNode pre = null; 
        ListNode next = null; 

        while(curr!=null){
            next = curr.next; 
            curr.next = pre; 
            pre = curr; 
            curr = next; 
        }

        ListNode dummy = head; 
        while(pre!=null && dummy!=null){
            ListNode x = dummy; 
            dummy = dummy.next;
            x.next = pre; 

            ListNode y = pre;
            pre = pre.next; 
            y.next = dummy; 
        } 

    }
}
