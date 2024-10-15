package Implementation;

public class Stackwll {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static class Stack {
    static Node head=null;
    static Node tail=null;
        
    public static boolean isEmpty(){
        return head==null;
    }
  
    public void push(int data){
        
        Node newNode=new Node(data);
        if (isEmpty()) {
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    
    public int pop(){
        if (isEmpty()) {
           return -1;
        }
        int val=head.data;
        head=head.next;
        return val;
    }
//
public int peek(){
    if (isEmpty()) {
        return -1;
    }

    return head.data;
}

//print 
public void print(){
    Node temp=head;
    while (temp!=null){
        System.out.print(temp.data+"-->");
        temp=temp.next;
    }
    System.out.print("null");
}
}
    







    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
       
       System.out.println("Peek val of Stack"+" "+s.peek());
       System.out.println(s.pop());

        s.print();
    }
}
