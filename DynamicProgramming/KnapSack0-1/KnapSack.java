import java.util.*;

/**
 * 0-1 KnapSack In knapsack problem we have weight array, value array and Weight
 * of knapsack(W). item wt[]= 2, 4, 5, 6 item vl[]= 10, 2 , 5 ,6
 * 
 * W=9kg In this problem we have choice as either we can can select one item or
 * leave it. 1. First thing we have choice 2. It is asking for maximum Value so
 * optimal structure.
 * 
 * In this problem base condition or smallest valid contdition is 1.when
 * n==0(means we do not have any items) ot when W=0(knapsack size is 0) Here we
 * return 0;
 * 
 * 2. Choice Diagram so Here If item wt > W(knapsack) then simply do not include
 * it. else wither include or leave it
 * max(vl[n-1]+knapsack(wt,vl,W-wt[n-1],n-1),knapsack(wt,vl,W,n-1)
 * 
 * THe above is recursive approach now we will convert it into memorization and
 * top down.
 * 
 * >> Memorisation : For this we will intialize one array in global let say dp.
 * We need to see what is size of this array and is it 1d or 2d; now : for this
 * problem , n and W is keep changing when we call the recursice fn. so we will
 * make the array dp[n][w] or dp[w][n]
 * 
 * >>Top Down Approach
 * 
 * 1. Initialization : Recursive fn base condition changes into initialization.
 * here where n and w is 0 we have to return answer =0; for matrix row and
 * column we choose the that variable of recursion which changes. here n and W;
 * 
 * Now the choice diagram convert into matrix and recursion fn name convert into
 * dp and if else condtion and rest things remain same.
 * 
 * 
 * 
 * 
 */
public class KnapSack {
    static int dp[][] = new int[1000][1000];

    static int knapsack(int wt[], int vl[], int W, int n) {
        if (dp[n][W] != -1)
            return dp[n][W];
        if (n == 0 || W == 0) // base condition
            return 0;
        if (wt[n - 1] <= W)
            return dp[n][W] = Math.max(vl[n - 1] + knapsack(wt, vl, W - wt[n - 1], n - 1), knapsack(wt, vl, W, n - 1));
        else
            return dp[n][W] = knapsack(wt, vl, W, n - 1);

    }

    static int knapsackTopDown(int wt[], int vl[], int W, int n) {
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
                    dp[i][j] = Math.max(vl[i - 1] + dp[i - 1][j - wt[i-1]],dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];

    }

    public static void main(String[] args) {
        int wt[] = new int[] { 10, 20, 30 };
        int vl[] = new int[] { 60, 100, 120 };
        int W = 50;
        int n = 3;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Answer : " + knapsack(wt, vl, W, n));
        System.out.println("Answer Top Down: " + knapsackTopDown(wt, vl, W, n));

    }
}