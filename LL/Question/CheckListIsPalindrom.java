package Question;



public class CheckListIsPalindrom {

 //Definition for singly-linked list.
 static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 

    public static boolean isPalindrome(ListNode head) {
        //First step find mid using slow and fast pointer
       ListNode mid=findMid(head);

       //Then reverse the second half

       ListNode curr=mid;
       ListNode prev=null;
       ListNode next;
       while(curr!=null){
         next =curr.next;
         curr.next=prev;
         prev=curr;
         curr=next;
       }

return checkSame(prev,head);

    }

    public static boolean checkSame(ListNode prev,ListNode head){
       ListNode right= prev;
       ListNode left = head;

       while(right != null){
        if(left.val != right.val){
            return false;
        }else{
            left=left.next;
            right=right.next;
        }
       }
       return true;
    }

    public static ListNode findMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
       
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    
}
