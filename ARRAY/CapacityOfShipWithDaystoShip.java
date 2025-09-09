package ARRAY;

public class CapacityOfShipWithDaystoShip {

    public static int shipWithinDays(int[] weights, int days) {
        // int low=Arrays.stream(weights).max().getAsInt();
        // int high=Arrays.stream(weights).sum();
int low = Integer.MIN_VALUE;
int  high = 0;
for (int w : weights) {
    high += w;
     low = Math.max(low, w);
}

    
     while(low<=high){
        int mid = (low+high)/2;
        if( DayRequired(weights,mid) <= days){
         high=mid-1;
        }else{
            low = mid+1;
        }
     }

     return low;
        // for(int i=max;i<sum;i++){
        //    int daysReq=DayRequired(weights,i);
        //    if(daysReq <= days) return i;
        // }
        //  return 0;
    }

    public static int DayRequired(int arr[],int cap){
        int day=1,load=0;

        for(int i=0;i<arr.length;i++){
           if(load+arr[i] > cap){
            day=day+1;
            load=arr[i];
           }else{
            load+=arr[i];
           }
        }
        return day;
    }

    public static void main(String[] args) {
        int weights[]={1,2,3,4,5,6,7,8,9,10};
        int Days=5;
        System.out.println(shipWithinDays(weights, Days));
        
    }
    
}