package Question;

public class RemoveNthNodeFromLast {
    
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp1 = head;
        int size = 0;
        while (temp1 != null) {
            temp1 = temp1.next;
            size++;
        }

        if (n == size) {
            return head.next;
        }
        ListNode temp = head;
        int i = 0;
        int toPrev = size - n - 1;
        while (i < toPrev) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }

}
