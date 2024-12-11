package Question;

public  class lList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // ADD FIRST
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // ADD LAST
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = head = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // ADD ANY INDEX
    public void addMd(int idx, int data) {
        if (idx == 0) {
            addFirst(8);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ITERATIVE APPROACH OF SEARCHING A KEY
    public int searchKey(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("key found at index" + i + " " + key);
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // REVERSE LL USING ITERATIVE APPROACH

    public void Reverse(int size) {
        Node prev = null;
        Node curr=tail=head;
        Node next;
        if (size == 1) {
            System.out.println("Reverse function called");
            return;
        }
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // DISPLAY DATA OF LL
    public   void displayData() {
        Node temp = head;
        if (temp == null) {
            System.out.println("ll is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // RECURSIVE APPROACH FOR SEARCHING A KEY
    public int helper(Node head, int key) {
        if (head == null) {
            System.out.println("key not found");
            return -1;
        }
        if (head.data == key) {
            System.out.println("key found");
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }

    // FIND NTH INDEX FROM THE LAST AND DELETE
    public void DeleteLast(int size, int n) {
        Node temp = head;
        if (size == 1) {
            System.out.println("DELETE LAST function called");
            return;
        } else if (n == size) {
            head = head.next;
            return;
        }
        int i = 0;
        while (i < size - n - 1) {
            temp = temp.next;
            i++;
        }
        System.out.println("Prev founded" + " " + temp.data);
        System.out.println("deleted from index" + " " + i);
        temp.next = temp.next.next;
        return;
    }

    // Find ll is palindrom or not
    // step1:find middle of ll By slow-fast approach

    public Node findMd(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Midium found" + slow);
        return slow;// Here Slow is the mid value
    }

    // Step 2: Reverse 2nd half

    public boolean isPalindrom() {
        if (head == null || head.next == null) {
            return true;
        }

        // Find mid
        Node mid = findMd(head);

        // Reverse second halfp
        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        System.out.println("Reverse Successfull");
        Node right = prev;
        Node left = head;

        // Check left==right

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
            System.out.println("Checking done");
        }
        return true;
    }
  
public static boolean isCyle(){
        Node slow=head;
        Node fast=head;
 if (head==null) {
    return false;
 }
 while (fast!=null && fast.next!=null){
    slow=slow.next;
    fast=fast.next.next;
    if(slow==fast){
        System.out.println("Here cycle is present"+" "+fast.data);
        return true;
    }  
 }
 return false;
}
    



public static void main(String[] args){
          lList ll = new lList();
            ll.addFirst(1);
            ll.addFirst(2);
            ll.addFirst(3);
            ll.addFirst(4);
            ll.addFirst(5);
           


  
    //     head=new Node(1);
    //     head.next=new Node(2);
    //     head.next.next=new Node(3);
    //     head.next.next.next=head;
    //     System.out.println(isCyle());
    //    // displayData();
        ll.displayData();

        // System.out.println(ll.recSearch(5));
       // ll.Reverse(size);
        ll.displayData();
        // ll.DeleteLast(size, 2);
        // ll.displayData();

         //System.out.println(ll.isPalindrom());
         
         //displayData();

        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);

        // ll.displayData();

        // int i = ll.searchKey(2);
        // System.out.println(ll.recSearch(4));
    }

}
