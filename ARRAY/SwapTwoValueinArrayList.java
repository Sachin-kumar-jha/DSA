package ARRAY;

import java.util.ArrayList;
import java.util.Collections;

public class SwapTwoValueinArrayList {
    public static void swap(ArrayList<Integer>list,int idx1,int idx2){
        int temp =list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      
swap(list, 0, 2);
Collections.sort(list);
      for(int i:list){
        System.out.println(i);
      }
    }
}
