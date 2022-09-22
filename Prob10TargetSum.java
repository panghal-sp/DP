class Prob10TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return targetSum(nums,0,target,new HashMap<String,Integer>());
    }
    
    private int targetSum(int [] nums,int currentIndex, int target ,  HashMap<String,Integer> memo){
        
        if(currentIndex >= nums.length){
            if(target != 0)
                return 0;
                else
                return 1;
        }
        
        String memoKey = Integer.toString(currentIndex)+"-"+Integer.toString(target);
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int sum1=targetSum(nums,currentIndex+1,target+nums[currentIndex],memo);
        int sum2=targetSum(nums,currentIndex+1,target-nums[currentIndex],memo);
        
        memo.put(memoKey,(sum1+sum2));
        return memo.get(memoKey);
        
    }
}
