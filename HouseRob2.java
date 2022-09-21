class HouseRob2 {
    public int rob(int[] nums) {

        if(nums.length==1)
            return nums[0];
        
        return Math.max(maxMoney(0,nums,new HashMap <Integer,Integer> (),nums.length-1),maxMoney(1,nums,new HashMap <Integer,Integer> (),nums.length));  
    }
    private int maxMoney(int house , int [] money , HashMap <Integer , Integer> memo,int length){

        if(house >= length)
            return 0;
        
        int memoKey=house;
        
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int robbed=money[house]+maxMoney(house+2,money,memo,length);
        int notRob = maxMoney(house+1,money,memo,length);
        
        memo.put(house,Math.max(robbed,notRob));
        
        return memo.get(memoKey);
    
    }
}
