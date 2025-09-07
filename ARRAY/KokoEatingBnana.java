package ARRAY;

public class KokoEatingBnana {
    
    public static int minEatingSpeed(int[] piles, int h) {
        int low=1,high=findMax(piles);
        while(low<=high){
            int mid = (low+high)/2;
            int totalHours=calculateTotalH(piles,mid);
            if(totalHours <= h){
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

public static int findMax(int arr[]){
    int max=Integer.MIN_VALUE;
    for(int i:arr){
        max=Math.max(i,max);
    }
    return max;
}
    public static int calculateTotalH(int arr[],int hourly){
        int total=0;
        for(int i:arr){
            total+= Math.ceil((double)i/hourly);
        }
        return total;
    }

    public static void main(String[] args) {
        int arr[]={3,6,7,11};
        System.out.println(minEatingSpeed(arr,8));
    }
}
