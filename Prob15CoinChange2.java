class Prob15CoinChange2 {
    public int change(int amount, int[] coins) {
        return totalCombinations(0,amount,coins,new HashMap<String , Integer> ());
    }
    
    private int totalCombinations(int currentIndex,int amount , int [] coins, HashMap <String,Integer> memo){
        
        if(amount == 0)
            return 1;
        if(currentIndex >= coins.length)
            return 0;
        
        String memoKey=currentIndex+"-"+amount;
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        int consider = 0;
        if(coins[currentIndex] <= amount)
            consider = totalCombinations(currentIndex,amount-coins[currentIndex],coins,memo);
        
        int notConsider=totalCombinations(currentIndex+1,amount,coins,memo);
        memo.put(memoKey,notConsider+consider);
        return memo.get(memoKey);
    }
}
