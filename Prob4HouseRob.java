class Prob4HouseRob {
    public int rob(int[] nums) {
        return maxMoney(0,nums,new HashMap <Integer,Integer> ());  
    }
    private int maxMoney(int house , int [] money , HashMap <Integer , Integer> memo){

        if(house >= money.length)
            return 0;
        
        int memoKey=house;
        
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int robbed=money[house]+maxMoney(house+2,money,memo);
        int notRob = maxMoney(house+1,money,memo);
        
        memo.put(house,Math.max(robbed,notRob));
        
        return memo.get(memoKey);
    
    }
}
