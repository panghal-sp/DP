class Prob36LongestPalindromeSubsequence {
    public int longestPalindromeSubseq(String text1) {
    String text2 = reverse(text1);
        int [] [] DP=new int[text1.length()][text1.length()];
        Arrays.stream(DP).forEach(a->Arrays.fill(a,-2));
        
      return longestCommon(text1,text2,0,0,new HashMap<String,Integer> (),text1.length(),text2.length(),DP);
    }
    private int longestCommon(String text1,String text2, int i , int j,HashMap<String,Integer> memo,int m , int n,int [] [] DP){
        
        if(i >= m ||  j>= n)
            return 0;
        
//         String memoKey=i+"-"+j;
        
//         if(memo.containsKey(memoKey))
//             return memo.get(memoKey);
        
        if(DP[i][j]!=-2)
            return DP[i][j];
        int ans=0,choice1=0;
        if(text1.charAt(i) == text2.charAt(j)){
            ans = 1+longestCommon(text1,text2,i+1,j+1,memo,m,n,DP);
            // ans=Math.max(ans,choice1);
        }
    else{
        int choice2=longestCommon(text1,text2,i+1,j,memo,m,n,DP);
        int choice3 = longestCommon(text1,text2,i,j+1,memo,m,n,DP);
        ans=Math.max(choice2,choice3);
        
    }
      //  memo.put(memoKey,ans);
        DP[i][j]=ans;
        return ans;
        
    }
    
    private String reverse(String s1){
    
    String ans = "";
    for(int i =s1.length()-1 ; i>=0; i--){
        ans+=s1.charAt(i);
    }
    return ans;
    }
}
