package ARRAY;

import java.util.ArrayList;
import java.util.List;

public class FindPermutation {

    public static List<List<Integer>> findPermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int num : arr) {
            if (temp.contains(num)) continue; // skip already used
            temp.add(num);
            backtrack(arr, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> list = findPermutations(arr);
        System.out.println(list);
    }
}
