package ARRAY;
public class MaxSumByPrefixsum {
    public static int printMaxSumSubarray(int arr[],int k){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        int prefix[]=new int[arr.length];

        //Calculate prefix Array
 int count=0;
 prefix[0] = arr[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                currSum = start==0 ? prefix[end] : prefix[end]-prefix[start-1];
               if (currSum == k) {
                count++;
               }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int arr[]={1,1,1};
        int k=2;
        System.out.println( printMaxSumSubarray(arr,k));
        // printMaxSumSubarray(arr,k);
    }
}
