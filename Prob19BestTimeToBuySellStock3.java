class Prob19BestTimeToBuySellStock3 {
    public int maxProfit(int[] prices) {
        
        // 1 - can buy 
        //0 - can sell
        int [][][] DP=new int [prices.length+1][2][3];
        Arrays.stream(DP).forEach(a-> Arrays.stream(a).forEach(b-> Arrays.fill(b,-1)));
        return maximumProfit(0,prices,1,2,new HashMap<String,Integer>(),DP);
    }
    
    private int maximumProfit(int currentDay,int [] prices,int canBuy,int transCount,HashMap<String,Integer> memo,int [][][] DP){

        if(currentDay >= prices.length || transCount == 0 )
            return 0;
        
//         String memoKey=currentDay+"-"+canBuy+"-"+transCount;
        
//         if(memo.containsKey(memoKey))
//             return memo.get(memoKey);
        
        if(DP [currentDay][canBuy][transCount] != -1)
            return DP [currentDay][canBuy][transCount];
        
        int ans=0;
        if(canBuy == 1){

            int idle=maximumProfit(currentDay+1,prices,canBuy,transCount,memo,DP);
            int buy= -prices[currentDay]+maximumProfit(currentDay+1,prices,0,transCount,memo,DP);
            ans=Math.max(idle,buy);
        }else{

            int idle=maximumProfit(currentDay+1,prices,canBuy,transCount,memo,DP);
            int sell= prices[currentDay]+maximumProfit(currentDay+1,prices,1,transCount-1,memo,DP);
            ans=Math.max(idle,sell);
        }
        DP [currentDay][canBuy][transCount] = ans;
        // memo.put(memoKey,ans);
        return DP [currentDay][canBuy][transCount];
    
    }
}
