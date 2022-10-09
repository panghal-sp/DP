class Prob33DiceRoll {
    public int numRollsToTarget(int n, int k, int target) {
        return totalWays(n,k,target,new HashMap<String,Integer> ());
    }
    
    private int totalWays(int dice, int faces , int target , HashMap<String,Integer> memo){
    
        if(dice == 0 && target == 0)
            return 1;
        
        if(dice == 0 || target <= 0)
            return 0;
        
        String memoKey = dice+"-"+target;
        
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int MOD=1000000007;
        
        int ans=0;
        
        for(int i=1; i <= faces ; i++){
        int tempAns = totalWays(dice-1,faces,target-i,memo)%MOD;
        ans=ans%MOD;
        ans=(ans+tempAns)%MOD;
            
        
        }
        memo.put(memoKey,ans);
        
        return memo.get(memoKey);
        
    
    }
}
