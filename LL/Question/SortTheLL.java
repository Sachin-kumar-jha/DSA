package Question;

public class SortTheLL {
   public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


    public ListNode sortList(ListNode head) {
        
      
        return sortLL(head);
    }

    ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
    // Create a dummy ListNode to serve
    // as the head of the merged list
    ListNode dummyListNode = new ListNode(-1);
    ListNode temp = dummyListNode;

    // Traverse both lists simultaneously
    while (list1 != null && list2 != null) {
        // Compare elements of both lists and
        // link the smaller ListNode to the merged list
        if (list1.val <= list2.val) {
            temp.next = list1;
            list1 = list1.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
        }
        // Move the temporary pointer
        // to the next ListNode
        temp = temp.next; 
    }

    // If any list still has remaining
    // elements, append them to the merged list
    if (list1 != null) {
        temp.next = list1;
    } else {
        temp.next = list2;
    }
    // Return the merged list starting 
    // from the next of the dummy ListNode
    return dummyListNode.next;
}

// Function to find the middle of a linked list
ListNode findMiddle(ListNode head){
    if (head == null || head.next == null) {
        return head;
    }

   
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    return slow;
}


ListNode sortLL(ListNode head){
    if (head == null || head.next == null) {
        return head;
    }
    

    ListNode middle = findMiddle(head);
    
    // Divide the list into two halves
    ListNode right = middle.next;
    middle.next = null;
    ListNode left = head;
    
    // Recursively sort the left and right halves
    left = sortLL(left);
    right = sortLL(right);
    
    // Merge the sorted halves using the
    // mergeTwoSortedLinkedLists function
    return mergeTwoSortedLinkedLists(left, right);
}

}

