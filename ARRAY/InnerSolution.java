package ARRAY;

public class InnerSolution {

    public static int minOperations(String s) {
	int count=0;
        if(s.length()-1==0 && s.charAt(0)=='a') return 0;
        else if (s.length()-1==0) {
            count += 122-(int)s.charAt(0)+1;
        }else
            for(int i=0;i<=s.length()-1;i++) {
		int code = s.charAt(i);
        System.out.println(s.charAt(i)+" "+"CODE :"+" "+code);
		// if(code == 122) {
        //     count += 1;
		// }
		count = Math.max((('a' - s.charAt(i) + 26) % 26),count);
        System.out.println(count);
        
	}
	return count;
    }

    public static void main(String[] args) {
        String s="yz";
        System.out.println(minOperations(s));
    }
}
