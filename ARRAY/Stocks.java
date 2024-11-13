package ARRAY;
 public class Stocks{
    public static int StocksSellAndBuy(int prices[]){
          int BuyPrice=Integer.MAX_VALUE;
          int MaxProfit=0;
          for(int i=0;i<prices.length;i++){
            if(BuyPrice<prices[i]){
     int profit=prices[i]-BuyPrice;
     MaxProfit=Math.max(MaxProfit, profit);
            }else{
           BuyPrice=prices[i];
            }
          }
          return MaxProfit;
    }
    public static void main(String[] args) {
        int prices[]={6,2,1,7,5};
System.out.println(StocksSellAndBuy(prices));
    }
}