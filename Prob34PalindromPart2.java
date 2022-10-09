class Prob34PalindromPart2 {
    public int minCut(String s) {
       return minCut(s,0,s.length()-1,new HashMap<String,Integer> ()); 
    }
    private int minCut(String s,int start,int end , HashMap<String,Integer> memo){
        if(isPalindrome( s,start, end))
            return 0;
        
        String memoKey= start+"-"+end;
        if(memo.containsKey(memoKey))
        return memo.get(memoKey);
        int ans = 10000;
        
        for(int i=start; i < end ; i++){
            if(isPalindrome(s,start,i)){
                int temp = 1+ minCut(s,i+1,end,memo);
                ans = Math.min(temp,ans);
                memo.put(memoKey,ans);
            }
            
        }
        return memo.get(memoKey);
    }
    
    private boolean isPalindrome(String s , int start , int end){

        while(start <= end){
            
            if(s.charAt(start) != s.charAt(end))
                return false;
            
            start++;
            end--;
        }
        return true;
        
        
    }
}
