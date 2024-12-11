package Recursion.Sorting;

public class Merge {
public static void MergeSort(int arr[],int si,int ei){
    if (si>=ei) {
        return;
    }
    int mid =si+(ei-si)/2;
    //For leftPart
    MergeSort(arr, si, mid); 
    //For RightPart
    MergeSort(arr, mid+1, ei);
    MergeArray(arr,si,mid,ei);
}

public static void MergeArray(int arr[],int si,int mid,int ei){
    //Create a temp array size st-ei+1
    int temp[]=new int[ei-si+1];

    //create iterator for leftPart
    int i=si;
    //create iterator for rightPart
    int j=mid+1;
    //create iterator for temp Array
    int k=0;

    //pushing element in sorted orde in temp
    
    while (i <= mid && j <= ei) {
        if (arr[i] < arr[j]) {
            temp[k] = arr[i];
            i++;
        }else{
            temp[k] = arr[j];
            j++;
        }
        k++;
    }

//Bche huye left part ke element ke liye loop
while (i <= mid) {
    temp[k++]=arr[i++];
}

//Bche huye right part ke element ke liye loop
while (j<=ei) {
    temp[k++]=arr[j++];
}

//Copy all temp value in Original arr Array

for ( k= 0, i=si; k < temp.length;k++,i++) {
     arr[i]=temp[k];
}

}


public static void display(int arr[]){
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
}
    public static void main(String[] args) {
        int arr[]={6,3,5,8,9,2};
MergeSort(arr, 0, arr.length-1);
display(arr);
    }
}
