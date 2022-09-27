class Prob16RodCut{
    public int cutRod(int price[], int n) {
        //code here
        int [] [] arr = new int[price.length][n+1];
        return totalProfit(0,price,n,new HashMap <String,Integer> (),arr);
    }
    
    private int totalProfit(int currentIndex,int [] price,int length, HashMap<String,Integer> memo,int [] [] arr){
        
        if(length == 0)
        return 0;
        
        if(currentIndex >= price.length)
        return 0;
       
        // String memoKey=Integer.toString(currentIndex)+"-"+Integer.toString(length);
        // if(memo.containsKey(memoKey))
        // return memo.get(memoKey);
        
        if(arr[currentIndex][length] != 0)
        return arr[currentIndex][length];
         int cut=0;
         
        if(length>=currentIndex+1)
         cut=price[currentIndex]+totalProfit(currentIndex,price,length-(currentIndex+1),memo,arr);
         else return 0;
         
         int notCut=totalProfit(currentIndex+1,price,length,memo,arr);
      arr[currentIndex][length]=Math.max(cut,notCut);
    //   memo.put(memoKey,Math.max(cut,notCut));
      return arr[currentIndex][length];
        
    }
}
