/**
 *  CoinChange Problem 2 :
 *  Here we need to know minimum number of coins we need to
 *  make the sum. We can take any coin any number of times.
 * 
 *  coins[]= {1,2,3} sum=5
 *  sum : 2+3=5--> 2coins
 *  sum : 2 + 2 + 1--> 5 3coins
 *  we have many ways but the optimal is first one { 2 + 3}
 *  so minimum coins is 2;
 * 
 *  This is variation of unbounded knapsack as we can take coin 
 *  any number of times.
 * 
 *   First thing is initialisation :
 * ** Unique
 * >> Here we need to initialise first two rows and first column;
 * ARR :  {2,2,3} sum=5
 * Now             SUM
 *          0       1     2      3      4    5
 *      0   inf    inf   inf    inf    inf  inf  
 *      1   0      inf   1      inf     2   inf    
 *      2   0            
 *      3   0   
 * 
 *  ** Here inf = MAX_VALUE-1 or INT_MAX-1 Why?
 * Answer : INT_MAX - 1, becasue if we take the  INT_MAX and add 1 to it
 *          it will round off and become -ve;
 * 
 *      
 * >> if we have nothing or 0 coin then mathematically we need
 *  infinite coins to to make a sum of anything.
 * 
 * >> Now if we want to create the sum 0 with more than 0 coin
 *   then we always need 0 coin which is minimum.
 * 
 * >>for second row we need to know if(j%arr[i]==0) then put dp[i][j]=j/arr[i];
 *    else dp[i][j]=INT_MAX-1; This is also the part of the initialisation
 * 
 * //    Code variation similar to unbounded knap sack instead of W we have sum here
 * // Instead of value we have to increment 1 in each case.
 * 
 *  if we choose coin then
 *   if(coin[i-1]<=j)
 *      t[i][j]= min (t[i][j - coin[i]] +1, t[i-1][j]);
 *  else 
 *    t[i][j] = t[i-1][j];
 * 
 * 
 * 
 */

public class CoinChangeSecond {

    public static void main(String[] args) {
        
    }
    
}
