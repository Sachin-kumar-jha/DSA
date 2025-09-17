package String;

public class IsomorphicString {
    public static boolean isoMorphicString(String s,String t){
        int []m1=new int[256],m2=new int[256];

       
        int n=s.length()-1;
        for(int i=0;i<n;++i){
            System.out.println(m1[s.charAt(i)]);
            if(m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)]=i+1;
            m2[t.charAt(i)]=i+1;
        }

        

        return true;
    }

    public static void main(String[] args) {
        String s="papersass",t="titlesss";
        System.out.println(isoMorphicString(s, t));
    }
}
