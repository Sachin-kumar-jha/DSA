package QUEUE.Implementation;
import java.util.*;
public class Queuewith2stack {
    static class QUEUE {
    static Stack<Integer>s1=new Stack<>();
    static Stack<Integer>s2=new Stack<>();

// //Push{O(n)} time complexity//

// public boolean isEmpty(){
//     return s1.isEmpty();
// }
// public void add(int data){
//     while (!s1.isEmpty()){
//         s2.push(s1.pop());
//     }

//     s1.push(data);
//     while (!s2.isEmpty()){
//         s1.push(s2.pop());
//     }

// }

// public int pop(){
//     if (isEmpty()) {
//         return -1;
//     }
//     return s1.pop();
// }

// public int peek(){
//     if (isEmpty()) {
//         return -1;
//     }
//     return s1.peek();
// }
     

//Pop [O(n)] comlexity //
public boolean isEmpty(){
    return s1.isEmpty() && s2.isEmpty();
 }

 public void add(int data){
    s1.push(data);  
 }

public  int  Pop(){
    if (s1.isEmpty() && s2.isEmpty()){
        return -1;
    }

    if (s2.isEmpty()) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    return s2.pop();
}


public int peek(){
    if (s1.isEmpty() && s2.isEmpty()){
        return -1;
    }

    if (s2.isEmpty()) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    // Peek at the front element from stack2
    return s2.peek();
}

}



    public static void main(String[] args) {
        QUEUE q=new QUEUE();
        q.add(1);
        q.add(2);
        q.add(3);
        
        System.out.println(q.peek());
          while (!q.isEmpty()){
             System.out.println(q.Pop());
     }
     
}
}
