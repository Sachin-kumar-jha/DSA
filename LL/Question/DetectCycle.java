package Question;

public class DetectCycle {
    public class Solution {
        static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public boolean hasCycle(ListNode head) {
        ListNode slow =head;
        ListNode fast=head;
      if(head==null){
        return false;
      }
      while(fast.next!=null&& fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            return true;
        }
      }
        return false;
    }
}
}
