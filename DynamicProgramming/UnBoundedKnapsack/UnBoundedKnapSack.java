/**
 * SImilar to 0-1 knapsack but multiple occurence of item is allowed.
 *  >> Multiple occurence of item is allowed.
 *   
 * Here for each item we have two choices for items..
 * 1.) either select or leave it
 * 
 * If we leave it , we have processed the item,
 * 
 * if we select it,  then in this case item is in process stage
 * because we can take it in multiple times.
 * 
 *  So here initialisation or base condtion is same
 *  if n=0 or W=0 return 0;
 * 
 * Seond is Choice diagram;
 *  if(w[i]>=W)
 *    max( vl[i]+ knapsack(wt,vl,n,W-vl[i]),  knapsack(wt,vl,n-1,W)) // Only difference in this line.
 * else
 *   knapsack(wt,vl,n-1,W)
 * 
 * ** RodCutting Problem is similar to unbounded knapsack.
 * 
 *   
 * 
 * 
 */

public class UnBoundedKnapSack {

    static int UnBoundedknapsack(int wt[], int vl[], int W, int n) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;// although array is already intialize with 0 but some other initial value we
                                 // have to do similar.
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
              //  if (wt[n - 1] <= W)// wrong
                   if (wt[i - 1] <= j)
                   //  dp[i][j] = Math.max(vl[n - 1] + dp[n - 1][W - wt[n-1]],dp[n-1][W]);// wrong here i is n and j is W. so correct is below.
                    dp[i][j] = Math.max(vl[i - 1] + dp[i][j - wt[i-1]],dp[i-1][j]);// only change istead of i-1 only use i.
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];

    }

    public static void main(String[] args) {
        int vl[] = {10, 30, 20}; 
        int wt[] = {5, 10, 15}; 
        int W = 100;
        int n = 3;
       
        System.out.println("Answer Unbounded Knapsack : " + UnBoundedknapsack(wt, vl, W, n));

    }
}