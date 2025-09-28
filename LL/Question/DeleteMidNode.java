package Question;

public class DeleteMidNode {
     public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return head.next;
        ListNode slow=head;
        ListNode fast=head;
        
        int mid=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            mid++;
        }

        ListNode temp=head;
        int i=0;
        while(i<mid-1){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return head;
    }
}
    
