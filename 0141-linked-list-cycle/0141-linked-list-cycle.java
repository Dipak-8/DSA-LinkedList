/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) 
            return false;
        ListNode tort = head;
        ListNode hare = head;
        while(hare != null && hare.next != null) {
            tort = tort.next;
            hare = hare.next.next;
            if(tort == hare)
                return true;
        }
        return false;
    }
}