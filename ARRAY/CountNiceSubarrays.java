package ARRAY;
class CountNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        // int count=0;
        // for(int start=0;start<nums.length;start++){
        //     int oddCount=0;

        // for(int end = start;end<nums.length;end++){
        //     if(nums[end]%2!=0){
        //        oddCount++;
        //     }
        //     if(oddCount>k){
        //         break;
        //     }
        //     if(oddCount ==k){
        //         count++;
        //     }
        // }
        // }
        // return count;

    //     Map<Integer,Integer> map=new HashMap<>();
 
    //  map.put(0,1); //Initialize the map with 0 odd;

    //  int result =0;
    //  int oddCount =0;

    //  for(int i :nums){
    //     if(i%2==1)oddCount++;

    //     if(map.containsKey(oddCount-k)){
    //         result += map.get(oddCount-k);
    //     }

    //     map.put(oddCount ,map.getOrDefault(oddCount,0)+1);
    //  }
      

    //   return result;



    // Function to return number of subarrays with exactly k odd numbers
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    

    public int countAtMost(int[] nums, int k) {
        int left = 0, res = 0;

        // Traverse through the array
        for (int right = 0; right < nums.length; right++) {
            // If current number is odd, reduce k
            if (nums[right] % 2 != 0)
                k--;

            // Shrink the window until k is valid
            while (k < 0) {
                if (nums[left] % 2 != 0)
                    k++;
                left++;
            }

            // Add valid subarrays ending at right
            res += (right - left + 1);
        }

        // Return result
        return res;
    }
}