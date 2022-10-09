//It is giving TLE 

class Prob35PalindromPart4 {
    public boolean checkPartitioning(String s) {
       return check(s,0,s.length()-1,2,new HashMap<String,Boolean>()); 
    }
    
    private boolean check(String s, int start , int end , int totalCut,HashMap<String,Boolean> memo){
        if(totalCut == 0  && isPalindrome(s,start,end))
            return true;
        
        //&& start == end-1
        
        if(totalCut <= 0)
            return false;
        
        String memoKey = start+"-#"+end+"-#"+totalCut;
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
            
        boolean ans = false;
        
        for(int i = start ; i < end ; i++){
            if(isPalindrome(s,start,i)){
                boolean temp= check(s,i+1,end,totalCut-1,memo);
                ans = ans||temp;
                memo.put(memoKey,ans);
            }
           
        }
       //  memo.put(memoKey,ans);
        return ans;
    }
    
    private boolean isPalindrome(String s , int start , int end){

    while(start <= end)
    {
        if(s.charAt(start) != s.charAt(end))
            return false;
        
        start++;
        end--;
    }
    return true;
    }
}
