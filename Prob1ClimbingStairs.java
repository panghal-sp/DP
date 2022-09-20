class Prob1ClimbingStairs {
    public int climbStairs(int n) {
        return totalWays(0,n,new HashMap <Integer,Integer> ()); 
    }
    
    public int totalWays(int currentStair, int targetStair, HashMap<Integer,Integer> hs){

        if(currentStair == targetStair)
            return 1;
        
        if(currentStair > targetStair)
            return 0;
        
        int key=currentStair;
        if(hs.containsKey(currentStair))
            return hs.get(currentStair);
        
        int onejump=totalWays(currentStair+1,targetStair,hs);
        int twojump=totalWays(currentStair+2,targetStair,hs);
        
        hs.put(currentStair,(onejump+twojump));
        
        return onejump+twojump;
    }
}
