class Prob12DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int largest = 0;
    
        for(int num : nums){
            if(num > largest){largest=num;}
            
        }
        int values [] = new int [largest+1];
        Arrays.fill(values, 0);
         for(int num : nums){
        //  values
            values[num] += 1;
        }
		return totalPoints(values,0,new HashMap<Integer,Integer> ());
 
    }
private int totalPoints(int [] values , int startPoint, HashMap<Integer,Integer> memo){
    if(startPoint >= values.length)return 0;
    
    int memoKey=startPoint;
    if(memo.containsKey(memoKey))
        return memo.get(memoKey);
    
    int twojump=startPoint*values[startPoint]+totalPoints(values,startPoint+2,memo);
    int onejump=totalPoints(values,startPoint+1,memo);
    memo.put(memoKey,Math.max(twojump,onejump));
    return memo.get(memoKey);
    
    
    }
    
}
