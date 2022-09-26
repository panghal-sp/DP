

class Prob13UnboundedKnapsak{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int [] [] dp= new int [N][W+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        
        return maxProfit(0,N,W,val,wt,new HashMap <String,Integer> (),dp);
    }
    
    static int maxProfit(int currentItem,int totalItem,int capacity, int [] values , int [] wt, HashMap <String,Integer> memo,int [] [] dp){
        
        if(capacity <= 0)
        return 0;
        
        if(currentItem == totalItem)
        return 0;
        
        // String memoKey=currentItem+"-"+capacity;
        if(dp[currentItem][capacity] != -1)
        return dp[currentItem][capacity];
        // if(memo.containsKey(memoKey))
        // return memo.get(memoKey);
        
        int consider=0;
        if(wt[currentItem] <= capacity)
        consider=values[currentItem]+maxProfit(currentItem,totalItem,capacity-wt[currentItem],values,wt,memo,dp);
        
        int notConsider=maxProfit(currentItem+1,totalItem,capacity,values,wt,memo,dp);
        
        dp[currentItem][capacity]=Math.max(consider,notConsider);
        // memo.put(memoKey,Math.max(consider,notConsider));
        
        return dp[currentItem][capacity];
    }
}
