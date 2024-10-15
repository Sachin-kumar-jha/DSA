package ARRAY;


public class SubArray {
    public static void  printSubArray(int arr[]){
        int max=0;
        for(int i=0;i<arr.length;i++){
            int start=i;
            int sum;
            
            for(int j=i;j<arr.length;j++){
                sum=0;
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(arr[k]+" ");
                    sum += arr[k];
                }
                System.out.println();
                if(max<sum){
                    max=sum;
                }
            }
            System.out.println();
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        printSubArray(arr);
    }
}
