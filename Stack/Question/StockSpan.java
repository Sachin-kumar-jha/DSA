package Question;

import java.util.Stack;

public class StockSpan {

    public static void stockSpan(int stocks[],int span[],Stack<Integer>s){
        //For first day's Span
        span[0]=1;
        s.push(1);

        //Loop for counting everyday span
        for(int i=0;i<stocks.length;i++){
            int currPrice=stocks[i];
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                span[i]= i+1;
            }else{
                int prevHigh=s.peek();
                System.out.println(prevHigh);
                span[i]=i-prevHigh;
            }
            s.push(i);
        }


    }
public static void main(String[] args) {
    Stack<Integer>s=new Stack<>();
    int stocks[]={100,80,60,70,60,85,100};
    int span[]=new int[stocks.length];

    stockSpan(stocks, span, s);

    for(int i=0;i<span.length;i++){
        System.out.print(span[i]+" ");
    }
}
}
