class Prob20BestTimetoBuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        
        return maximumProfit(0,prices,1,k,new HashMap<String,Integer>());
    }
      
    private int maximumProfit(int currentDay,int [] prices,int canBuy,int transCount,HashMap<String,Integer> memo){

        if(currentDay >= prices.length || transCount == 0 )
            return 0;
        
        String memoKey=currentDay+"-"+canBuy+"-"+transCount;
        
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int ans=0;
        if(canBuy == 1){

            int idle=maximumProfit(currentDay+1,prices,canBuy,transCount,memo);
            int buy= -prices[currentDay]+maximumProfit(currentDay+1,prices,0,transCount,memo);
            ans=Math.max(idle,buy);
        }else{

            int idle=maximumProfit(currentDay+1,prices,canBuy,transCount,memo);
            int sell= prices[currentDay]+maximumProfit(currentDay+1,prices,1,transCount-1,memo);
            ans=Math.max(idle,sell);
        }
        memo.put(memoKey,ans);
        return memo.get(memoKey);
    
    }
}
