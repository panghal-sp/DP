class Prob37EditDistance {
    public int minDistance(String word1, String word2) {
       return minOps(word1,word2,0,0,word1.length(),word2.length(),new HashMap<String,Integer>()); 
    }
    private int minOps(String s1,String s2,int i,int j , int m , int n, HashMap<String,Integer> memo){
        
        if(j >= n)
            return m-i;
        if(i >= m)
            return n-j;
        
            String memoKey = i+"-"+j;
        
        if(memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        int ans = 1000001;
        if(s1.charAt(i) == s2.charAt(j))
            ans=minOps(s1,s2,i+1,j+1,m,n,memo);
        else{
            int insertion = 1+minOps(s1,s2,i,j+1,m,n,memo);
            int deletion = 1+minOps(s1,s2,i+1,j,m,n,memo);
            int replace = 1+minOps(s1,s2,i+1,j+1,m,n,memo);
            ans=Math.min(insertion,Math.min(deletion,replace));
        }
        memo.put(memoKey,ans);
        return memo.get(memoKey);
    }
}
