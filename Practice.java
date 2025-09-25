public class Practice {

    static class Node{
       int data;
       Node next;
       Node(int data){
        this.data=data;
        this.next=null;
       }
    }

    public static Node head,tail;
    public static int size;
    public static void addFirst(int data){
         Node newNode=new Node(data);
         if(head==null){
            head=tail=newNode;
            return;
         }
         newNode.next=head;
         head=newNode;
    }

    public static void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
     tail.next=newNode;
     newNode=tail;
    }

    public static void addAtIndex(int idx,int data){
        if(idx==0){
            addFirst(data);
        }
        Node temp=head;
        int i=0;
        while (i<idx-1) {
            temp=temp.next;
            i++;  
        }
  
        Node newNode=new Node(data);
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public static void printLinkedList(){
        if (head==null) {
            System.out.println("LL is empty");
        }
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        // String str="raju";
        // String str1="raju";
        // String st=new String("raju");
        // String st1=new String("raju");
        // System.out.println(st==st1);
        // System.out.println(str==str1);
        // System.out.println(str==st);

          

        Practice.addFirst(2);
        Practice.addFirst(4);
        Practice.addFirst(5);
        Practice.addLast(6);
        Practice.addAtIndex(1, 7);

        Practice.printLinkedList();

    }
}