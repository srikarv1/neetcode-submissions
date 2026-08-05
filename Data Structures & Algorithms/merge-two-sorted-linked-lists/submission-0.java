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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h1 = list1, h2 = list2; 

        ListNode dummy2 = new ListNode(-1, null);
        ListNode dummy = dummy2; 
        while(h1 != null && h2 != null){
            if(h1.val<h2.val){
                dummy.next = h1;
                h1 = h1.next;
            }
            else{
                dummy.next = h2;
                h2 = h2.next; 
            }  
            dummy = dummy.next;
        }

        while(h1 != null){
            dummy.next =h1;
            h1 = h1.next;        
            dummy = dummy.next;
        } 

        while(h2 != null){
            dummy.next = h2; 
            h2 = h2.next;
            dummy = dummy.next;
        }
        return dummy2.next; 
    }
}