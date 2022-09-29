class Prob25ReachScore {
    public long count(int n) {
        
        int [] ar = {3,5,10};
        
        return totalWays(0,n,ar, new HashMap<String ,Long> ());
    }
    private long totalWays(int ci,int totalScore,int [] scores,HashMap <String,Long> memo){
        
        // if(totalScore < 0)
        // return 0;
        
        if(totalScore == 0)
        return 1;
        
        if(ci >= scores.length)
        return 0;
        
        String memoKey = ci+"-"+totalScore;
        
        if(memo.containsKey(memoKey))
        return memo.get(memoKey);
        long consider=0;
        if(totalScore >= scores[ci])
       consider = totalWays(ci,totalScore-scores[ci],scores,memo);
        long idle=totalWays(ci+1,totalScore,scores,memo);
        
        memo.put(memoKey,(consider+idle));
        return memo.get(memoKey);
       
    }
}
