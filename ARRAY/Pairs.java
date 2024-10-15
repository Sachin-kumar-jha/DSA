package ARRAY;

public class Pairs {
  
    public static void printPairs(int arr[]){
        int totalPairs=0;
        int curr=0;
        for(int i=0;i<arr.length;i++){
            curr=arr[i];
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+ curr+","+ arr[j] +")" +" ");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println(totalPairs);
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        printPairs(arr);
        }
}
