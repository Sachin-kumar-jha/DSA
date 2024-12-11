package Recursion.Question;

public class firstOccurence {
    public static int FirstOccurence(int arr[],int i,int key){
        
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key){
            return i;
        }
        

      return  FirstOccurence(arr, i+1,key);
    }

    public static int LastOccurence(int arr[],int i,int key){
        if (i == arr.length) {
            return -1;
        }

        int isFound = LastOccurence(arr, i+1, key);
        if (isFound == -1 && arr[i] == key){
            return i;
        }

        return isFound;

    }
    
     public static void main(String[] args) {
        int arr[]={5,5,4,5,6,5};
        System.out.println(LastOccurence(arr, 0,5));
     }
}
