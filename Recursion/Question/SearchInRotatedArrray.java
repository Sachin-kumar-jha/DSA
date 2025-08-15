package Recursion.Question;


public class SearchInRotatedArrray {
public static int search(int arr[],int si,int target,int ei){
    if (si>ei) {
        return -1;
    }
    int mid=si+(ei-si)/2;
//Best Case
 if (arr[mid]==target) {
    return mid;
 }

//Case 1: Mid lies on Line 1
if (arr[mid] > target) {
    //case a
    if (arr[si]<=target && target <= arr[mid]) {
      return  search(arr, si, target, mid-1);
    }else{
    return search(arr, mid+1, target, ei);
    }
    

}

//mid lies on L2
else{
  //case c right 
  if (arr[mid] <= target && target <= arr[ei]){
    return search(arr, mid+1, target, ei);
  }else{
 //case d left
    return search(arr, si, target, mid-1);
  }
}


}



    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2,3};
        int target=0;
    int targetIdx=search(arr,0, target,arr.length-1);
    System.out.println(targetIdx);
    }
    
    
}
