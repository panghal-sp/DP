class Prob24JumpGame2 {
    public int jump(int[] nums) {
        return minJump(0,nums,new HashMap<Integer,Integer> ());
    }
    private int minJump(int currentIndex,int [] nums, HashMap<Integer,Integer> memo){

    if(currentIndex >= nums.length-1)
        return 0;
        
        if(nums[currentIndex] == 0)
            return 100001;
        
        int memoKey = currentIndex;
        
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        
        
        int currentJumps = nums[currentIndex];
        
        int ans=100001;
        for(int i=1;i<=currentJumps;i++){
            int tempAns=1+minJump(currentIndex+i,nums,memo);
            ans=Math.min(tempAns,ans);
        }
        memo.put(memoKey,ans);
        return memo.get(memoKey);
    }
}
