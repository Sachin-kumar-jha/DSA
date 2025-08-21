package ARRAY;

public class SortColors {

   /**
    *  Better sollution to sort 0's,1's and 2's elements in an array
    by taking three variable for each element 
    count0,count1,count2
    */
    public static void Bettersort(int arr[]){
        int count0=0,count1=0,count2=0;

        for(int i:arr){
            if(i==0){
                count0++;
            }else if(i==1){
                count1++;
            }else if(i==2){
                count2++;
            }
        }
        int index=0;
        for(int i=0;i<count0;i++){
            arr[index++]=0;
        }
         for(int i=0;i<count1;i++){
            arr[index++]=1;
        }
         for(int i=0;i<count2;i++){
            arr[index++]=2;
        }

    }

    public static void optimizedSort(int arr[]){
        int low=0,mid=0,high=arr.length-1;

        while (mid<=high) {
            if (arr[mid]==0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }else if (arr[mid]==1) {
                mid++;
            }else if (arr[mid]==2) {
                swap(arr, mid, high);
                high--;
            }
        }

    }
    public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
public static void main(String[] args) {
    int nums[]= {2,0,2,1,1,0};
    Bettersort(nums);
    optimizedSort(nums);
    for(int i:nums){
        System.out.print(i);
    }
}
    
}