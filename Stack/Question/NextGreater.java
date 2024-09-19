package Question;

import java.util.Stack;

public class NextGreater {

public static  int [] greaterNext(int []arr,int[] bb,Stack<Integer>s){
  for(int i=arr.length-1; i>=0; i--){

    while (!s.isEmpty()){
    if(arr[ s.peek()] <= arr[i]){
        s.pop();
      }else{
        break;
      }
    }
    if (s.isEmpty()) {
        bb[i]=-1;
    }else{
        bb[i]=arr[s.peek()];
    }
    s.push(i);
  }
   return bb;
}


 public static void main(String[] args){
    Stack<Integer>s=new Stack<>();
int [] arr={5,7,6,0,2,3};
int nextGreate[]=new int[arr.length+1];

      int []greater=greaterNext(arr,nextGreate,s);

      for(int i=0;i<greater.length-1;i++){
        System.out.println(greater[i]);
      }
    }
}
