package ARRAY;

public class Reverse {
    public static void ReverseArray(int arr[]){
        int first=0; int last=arr.length-1;
        for(int i=0;i<arr.length;i++){
            if (first<last) {
                 int temp=arr[first];
            arr[first]=arr[last];
            arr[last]=temp;
            first++;
            last--;
            }
           
        }

    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        ReverseArray(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
