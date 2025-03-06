/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode after = temp.next;
            temp.next = prev;
            prev = temp;
            temp = after;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        ListNode newHead = reverseLL(temp);
        slow = head;

        while(newHead != null) {
            if (slow.val != newHead.val) {
                reverseLL(temp);
                return false;
            }
            slow = slow.next;
            newHead = newHead.next;
        }
        reverseLL(temp);
        return true;
    }
}