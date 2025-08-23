package Recursion.Question;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),result);
        return result;
    }
    
    public static void backtrack(int nums[],List<Integer>list,List<List<Integer>>result){
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int num:nums){
            if(list.contains(num)) continue;
            list.add(num);
            backtrack(nums,list,result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int nums[]={3,2,1};
       System.out.println(permute(nums));
    }
}
