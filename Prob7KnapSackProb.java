class Prob7KnapSackProb 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         return maxProfit(0,n,W,wt,val,new HashMap <String,Integer>());
    } 
    
   private static int maxProfit(int currentItem , int n , int capacity, int [] weight,int [] profit , HashMap <String,Integer> memo){
       
       if(currentItem == n)
       return 0;
       
       int currentItemWt=weight[currentItem];
       int currentProfit = profit[currentItem];
       int consider=0;
       
       String memoKey=Integer.toString(currentItem)+"#"+Integer.toString(capacity);
       if(memo.containsKey(memoKey))
       return memo.get(memoKey);
       
       if(capacity >= currentItemWt)
         consider=currentProfit+maxProfit(currentItem+1,n,capacity-currentItemWt,weight,profit,memo);
         
       int notConsider=maxProfit(currentItem+1,n,capacity,weight,profit,memo);
       
       memo.put(memoKey,Math.max(consider,notConsider));
       
       return memo.get(memoKey);
   }
}
