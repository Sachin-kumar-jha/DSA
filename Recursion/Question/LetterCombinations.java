
package Recursion.Question;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    private final String []map;
   LetterCombinations(){
     map=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz",};
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        helper(digits,ans,0,"");
        return ans;

    }

    public void helper(String digits,List<String>ans,int index,String current){
        if(digits.length()==0)return;
        if(index==digits.length()){
            ans.add(current);
            return;
        }

            String s = map[digits.charAt(index) - '0'];

        for(int i=0;i<s.length();i++){
            helper(digits,ans,index+1,current+s.charAt(i));
        }
    }

}