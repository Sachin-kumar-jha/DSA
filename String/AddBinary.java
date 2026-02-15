package String;

public class AddBinary {

  public static String  binaryAdd(String s1,String s2){
    StringBuilder s = new StringBuilder();
    int m = s1.length()-1;
    int n = s2.length()-1;

    int sum = 0;
    int carry = 0;

    while(m>=0 || n>=0){
        sum = carry;

        if(m>=0){
            sum+=s1.charAt(m)-'0';
            m--;
        }
        if(n>=0){
            sum += s2.charAt(n)-'0';
            n--;
        }
        s.append((sum%2==0)?'0':'1');
        carry =  (sum>1)?1:0;
    }
     
    if(carry == 1){
          s.append('1');
    }

    return s.reverse().toString();

  }
    public static void main(String[] args) {
        String s1 = "11";
        String s2 = "1";
        String s =  binaryAdd(s1,s2);
     System.out.println(s);
    }
    
}