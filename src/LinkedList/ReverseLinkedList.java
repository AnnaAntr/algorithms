package LinkedList;

// LeetCode #206
public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        head.next = null;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr == null ? null : curr.next;
        }

        return prev;
    }
}
