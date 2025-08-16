package Recursion.Question;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),result);
        return result;
    }
    
    public void backtrack(int nums[],List<Integer>list,List<List<Integer>>result){
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

}
