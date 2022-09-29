class Prob23JumpGame {
    public boolean canJump(int[] nums) {
        
        int max_reach = nums[0];
        
        if(nums.length == 1) return true; 
        
        for(int i = 1; i < nums.length; i++){
            
            if (i > max_reach)
                    return false;
            
            if(max_reach < nums[i] + i){
                max_reach = nums[i] + i;
            }
            
            
        }
        
        return true;
    }
    

        //return canJump(0,nums,new HashMap <String,Boolean> ());
   // }
    
//     DP SOLUTION BUT THIS QUESTION IS OF GREEDY APPROACH 
    
//     private boolean canJump(int ci,int [] nums , HashMap <String,Boolean> memo){
        
//         if(ci >= nums.length-1)
//             return true;
        
//         if(nums[ci] == 0)
//             return false;
        
//         boolean ans = false;
//         for(int i=1 ; i<=nums[ci] ; i++)
//         {
//             boolean isPossible = canJump(ci+i,nums,memo);
//             ans= ans || isPossible;
//         }
//     return ans;
//     }
}
