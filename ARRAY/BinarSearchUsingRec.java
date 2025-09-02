package ARRAY;

public class BinarSearchUsingRec {
   public static int bSearch(int arr[],int si,int ei,int target){
    if(si>ei){
        return -1;
    }
    int mid =si+(ei-si)/2;

    if(arr[mid] == target){
        return mid;
    }else if(arr[mid]<target){
        return bSearch(arr,mid+1,ei,target);
    }
    else return bSearch(arr,si,mid-1,target);

   }
public static void main(String[] args) {
    int nums[]={-1,0,3,5,9,12};
    System.out.println(bSearch(nums,0,nums.length-1,9));
}
}
