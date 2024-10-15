package Implementation;
public class StackwithArr {
    static class Innerstack {
      static int size;
      static int top=-1;
      static int arr[];
     Innerstack(int n){
        size=n;
        arr=new int [size];
       
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(int data){
        if(top==size-1){
         System.out.println("Stack is full");
         return;
        }
        top++;
        arr[top]=data;
    }

    public int pop(){
        if (isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }
        
        int data=arr[top];
        top--;
        return data;
    }

    public int  peek(){
    return arr[top];
    }
    }
    public static void main(String[] args) {
        Innerstack s1=new Innerstack(4);
        // s1.push(1);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);

        System.out.println(s1.pop());
        System.out.println(s1.peek());

        // while (!s1.isEmpty()){
        //     System.out.println(s1.peek());
        //     s1.pop();
        // }
        


    }
}

