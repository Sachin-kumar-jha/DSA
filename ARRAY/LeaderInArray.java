package ARRAY;

import java.util.ArrayList;
import java.util.List;

public class LeaderInArray {
    public static List<Integer> leaderinArray(int []arr){
    List<Integer> list= new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        
        
        for(int i=arr.length-1;i>=0;i--){
            
            if (arr[i] > max) {
                list.add(arr[i]);
                max=Math.max(max, arr[i]);
            }
          
        }
        return list;
    }
    public static void main(String[] args) {
        int arr[]={10,22,12,0,3,6};
        List<Integer>list=leaderinArray(arr);
    System.out.println(list);
    }
}
