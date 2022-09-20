class Prob3MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
         HashMap <Integer,Integer> memo=new HashMap <> ();
        return Math.min(minCost(0,cost, memo),memo.get(1));
    }
    
    private int minCost(int startpoint , int [] cost , HashMap<Integer,Integer> memo ){

        if(startpoint==cost.length)
            return 0;
      else  if(startpoint>cost.length)
            return 1001;

        
        int memoKey=startpoint;
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int a=cost[startpoint]+minCost(startpoint+1,cost,memo);
        int b=cost[startpoint]+minCost(startpoint+2,cost,memo);
        
        memo.put(startpoint,(Math.min(a,b)));
        return Math.min(a,b);
    
    }
}
