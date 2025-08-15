public class Launch {

    public static void MergeSort(int arr[],int si,int ei){
        //Base case 
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        System.out.print("mid "+" :"+mid);
        MergeSort(arr, si, mid); //Left part 
        MergeSort(arr, mid+1, ei);
        merge(arr,si,ei,mid);
    }


    public static void merge(int arr[],int si,int ei,int mid){
     int temp[]=new int[ei-si+1];
    
     int ileft=si;
     int iright=mid+1;
      int k =0;
     while (ileft<=mid && iright<=ei){

        if(arr[ileft]<arr[iright]){
            temp[k]=arr[ileft];
            ileft++;
        }else{
               temp[k]=arr[iright];
               iright++;
        }
        k++;
     }

while (ileft<=mid){
temp[k++]=arr[ileft++];
}
while (iright<=ei) {
    temp[k++]=arr[iright++];
}

//Copying to temp to original array
int j=si;
for(int i:temp){
   
arr[j]=i;
j++;
}
    }

    public static void PrintArr(int arr[]){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int arr[]={5,6,3,2};
        MergeSort(arr, 0, arr.length-1);
      
    }

    
}




