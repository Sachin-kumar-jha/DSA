package Implementation;

import java.util.ArrayList;


public class StackwithArraylist {

 static class Stack{
      ArrayList<Integer>list=new ArrayList<>();

    //Check stack is empty
public  boolean isEmpty(){
   return list.size()==0;
}

//push add element 

public void push(int data ){
    list.add(data);
}

//pop
public  int pop(){
    if (isEmpty()){
        return -1;
    }
    int top=list.get(list.size()-1);
    list.remove(list.size()-1);
    return top;
}

//Peek
public  int  peek(){
    if (isEmpty()) {
        return -1;
    }
    return list.get(list.size()-1);
}

}



public static void main(String[] args) {
    Stack s1=new Stack();
    s1.push(1); 
    s1.push(2);
    s1.push(3);
    s1.pop();
    s1.pop();
    s1.pop();
    s1.pop();
    System.out.println(s1.peek());
//System.out.println(top);

while (!s1.isEmpty()) {
    System.out.println(s1.peek());
    s1.pop();
}


    }
}
