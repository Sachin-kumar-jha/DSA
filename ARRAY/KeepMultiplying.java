class KeepMultiPlying{
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
         int result = original;

        boolean found = true;

        while (found) {
            found = false;
            for (int i : nums) {
                if (i == result) {
                    result *= 2;
                    found = true;
                    break;
                }
            }

        }
        return result;

        // Set<Integer>set=new HashSet<>();
        // for(int i:nums){
        //     set.add(i);
        // }

        // while(set.contains(result)){
        //     result*=2;
        // }
        // return result;
    }
}