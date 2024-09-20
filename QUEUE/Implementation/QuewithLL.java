package QUEUE.Implementation;

public  class QuewithLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head=null;
    static Node tail=null;

    public  boolean isEmpty(){
        return head==null && tail==null;
    }

//Add rear
    public  void add(int data){
        Node newNode =new Node(data);
        if (isEmpty()) {
            head=tail=newNode;
            return;
        }
    tail.next=newNode;
    tail=newNode;
}

//Remove from front 
public int Remove(){
    if (isEmpty()){
        System.out.println("Queue is empty");
        return -1;
    }
    int data=head.data;
    if (head==tail) {
        head=tail=null;
    }else{
        head=head.next;
    }
return data;

}

public int peek(){
    if (isEmpty()){
        System.out.println("Queue is empty");
        return -1;
    }
    return head.data;
}


    public static void main(String[] args) {
        QuewithLL q=new QuewithLL();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.Remove();  
        }
        System.err.println(q.peek());
    }
}
