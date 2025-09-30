package LL.Question;

public class ReverseNodeInKthGroup {
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;
        while (true) {
            // Check if there are k nodes ahead
            ListNode kth = getKthNode(curr, k);
            if (kth == null)
                break;
            ListNode nextGroupStart = kth.next;

            // Reverse this group
            ListNode prev = nextGroupStart;
            ListNode node = curr;
            while (node != nextGroupStart) {
                ListNode temp = node.next;
                node.next = prev;
                prev = node;
                node = temp;
            }

            prevGroupEnd.next = kth;

            prevGroupEnd = curr;

            curr = nextGroupStart;
        }

        return dummy.next;
    }

    // Helper to get kth node from curr
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 1) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

}