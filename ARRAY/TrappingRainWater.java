package ARRAY;
import java.util.*;
public class TrappingRainWater{
    public static int TrappedWater(int arr[]){
        int n=arr.length;
        //Calculate left Max array
        int leftMax[]=new int[n];
        leftMax[0]=arr[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(arr[i],leftMax[i-1]);
        }

        //Calculate RightMax array

        int RightMax[]=new int[n];
        RightMax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            RightMax[i]=Math.max(arr[i],RightMax[i+1]);
        }

        //Loop for calculating waterlevel and trappedwater
        int trappedwater=0;
        for(int i=0;i<n;i++){
            int waterlevel=Math.min(leftMax[i],RightMax[i]);
            System.out.println(waterlevel);
            trappedwater += waterlevel-arr[i];
        }
        return trappedwater;
    }
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        System.out.println(TrappedWater(height));
    }
}
