class Prob22BestTimeToBuySellStockFees {
    public int maxProfit(int[] prices, int fee) {
        int [][] ar=new int [prices.length+1][2];
        return maximumProfit(0,prices,1,fee,new HashMap<String,Integer>());
    }
      
    private int maximumProfit(int currentDay,int [] prices,int canBuy,int fee,HashMap<String,Integer> memo){

        if(currentDay >= prices.length )
            return 0;
        
        String memoKey=currentDay+"-"+canBuy;
        
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int ans=0;
        if(canBuy == 1){

            int idle=maximumProfit(currentDay+1,prices,canBuy,fee,memo);
            int buy= -prices[currentDay]+maximumProfit(currentDay+1,prices,0,fee,memo);
            ans=Math.max(idle,buy);
        }else{

            int idle=maximumProfit(currentDay+1,prices,canBuy,fee,memo);
            int sell= -fee+prices[currentDay]+maximumProfit(currentDay+1,prices,1,fee,memo);
            ans=Math.max(idle,sell);
        }
        memo.put(memoKey,ans);
        return memo.get(memoKey);
    
    }
}
