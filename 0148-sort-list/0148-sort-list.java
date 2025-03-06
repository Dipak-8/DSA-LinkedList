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
    public ListNode findMid(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(leftHead != null && rightHead != null) {
            if(leftHead.val <= rightHead.val) {
                temp.next = leftHead;
                leftHead = leftHead.next;
            }
            else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }
        if(leftHead != null)
            temp.next = leftHead;
        else
            temp.next = rightHead;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode midNode = findMid(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return mergeList(left, right);
    }
}