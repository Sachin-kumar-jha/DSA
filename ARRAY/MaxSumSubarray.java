 package ARRAY;

 class MaxSumSubarray{
    public static void MaxSum(int arr[]){
        int maxsm=Integer.MIN_VALUE;
            int currSum=0;
        for(int i=0;i<arr.length;i++){
            currSum=currSum+arr[i];
            if (currSum<0) {
                currSum=0;
            }
           maxsm=Math.max(currSum,maxsm);
}
System.out.println(maxsm);
    }
    public static void main(String[] args) {
        int arr[]={-2,-3,4,-1,-2,1,5,-3};
        MaxSum(arr);
    }
}