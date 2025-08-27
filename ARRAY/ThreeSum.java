package ARRAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int []arr){
        
        
        
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1 ; k<arr.length;k++){
                    if ((arr[i]+arr[j]+arr[k])==0) {
                        List<Integer> ls=new ArrayList<>();
                        ls.add(arr[i]);
                        ls.add(arr[j]);
                        ls.add(arr[k]);
                       Collections.sort(ls);
                       set.add(ls);
                    }
                }
            }
        }

        
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> betterSolution(int arr[]){
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            Set<Integer>hashSet=new HashSet<>();
            for(int j=i+1;j<arr.length;j++){
                   int third= -(arr[i]+arr[j]);
                   if(hashSet.contains(third)){
                    List<Integer>ls=new ArrayList<>();
                       ls.add(arr[i]);
                        ls.add(arr[j]);
                        ls.add(third);
                       Collections.sort(ls);
                       set.add(ls);
                   }

                hashSet.add(arr[j]);
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> optimalSolution(int nums[]){
        List<List<Integer>>ls=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while (j<k) {
                int sum= nums[i]+nums[j]+nums[k];
                if (sum>0) {
                    k--;
                }else if (sum<0) {
                    j++;
                }else{
                    List<Integer>list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ls.add(list);
                    j++;
                    k--;
                    while (j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return ls;
    }
    public static void main(String[] args) {
        int arr[]={-2,0,1,1,2};
        Arrays.sort(arr);
        List<List<Integer>>list=optimalSolution(arr);

        System.out.println(list);
    }
}
