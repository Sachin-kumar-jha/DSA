package ARRAY;

public class ReversePairs {
    public static int reversePairs(int[] nums) {
        // int count=0;

        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]>2*nums[j]){
        //             count++;
        //         }
        //     }
        // }
        return MergeSort(nums,0,nums.length-1);
    }


    public static int MergeSort(int arr[],int si,int ei){
        int count=0;
    if (si>=ei) {
        return count;
    }
    int mid =si+(ei-si)/2;
    //For leftPart
    count+=MergeSort(arr, si, mid); 
    count+=MergeSort(arr, mid+1, ei);
    count+=countPairs(arr,si,mid,ei);
    MergeArray(arr,si,mid,ei);
    return count;
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

public static int countPairs(int arr[], int si, int mid, int ei) {
    int right = mid + 1;
    int count = 0;
    
    for (int i = si; i <= mid; i++) { 
        while (right <= ei && (long)arr[i] > 2L * arr[right]) {
            right++;
        }
        count += (right - (mid + 1));
    }
    return count;
}

public static void main(String[] args) {
    int nums[]={1,3,2,3,1};
    System.out.println(reversePairs(nums));
}

}
