public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> str=new ArrayList<>();
         generate(n,"",str);
         return str;

    }

public boolean isValid(String st){
    int val=0;
    for(char a:st.toCharArray()){
       if(a=='(') val++;
       else
       val--;
       if(val<0) return false;
    }
    return val==0;
}
    public  void generate(int n, String curr, List<String> result) {
        if (curr.length() == 2*n) {
           if(isValid(curr))  result.add(curr);
            return;
        }
        
        generate(n, curr + "(", result);
        generate(n,curr+")",result);
    }

}
