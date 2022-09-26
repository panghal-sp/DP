class Prob14CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        
        int [] [] dp = new int [coins.length][amount+1];
        Arrays.stream(dp).forEach(a-> Arrays.fill(a,-111));
        int ans = minCoins(coins, 0, amount, new HashMap<String,Integer>(),dp);
        
        
        
        if(ans == 100000){
            return -1;
        }
        
        return ans;
    }
    public int minCoins(int[] coins, int currentIndex, int amount, HashMap<String,Integer> memo,int [] [] dp){
        
        if(amount==0)
            return 0;
        if(currentIndex >= coins.length)
            return 100000; //Maximum Value of Amount in constraints
        
        if(dp [currentIndex][amount] != -111)
          return  dp [currentIndex][amount];
//         String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(amount);
        
//         if(memo.containsKey(currentKey)){
//             return memo.get(currentKey);
//         }
        
        int consider = 100000; // 
        if(coins[currentIndex] <= amount){
            consider = 1 + minCoins(coins, currentIndex, amount - coins[currentIndex], memo,dp);
        }
        
        int notConsider = minCoins(coins, currentIndex + 1, amount, memo,dp);
        dp [currentIndex][amount] =Math.min(consider, notConsider);
        // memo.put(currentKey, Math.min(consider, notConsider));
        
        return dp [currentIndex][amount]; 
    }
}
