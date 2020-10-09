

/**
 *  This is the variation of knapsack here we have single array arr, In knapsack we have single array
 *  item which has two property weight and value and we have W(knapsack size) which is here sum(S);
 * 
 * Recursion fn :
 * Base condition :
 * if(sum==0)
 *   return true;
 * if(n==0)
 *  return false;
 * 
 * choice diagram :
 * 
 *  if(arr[i] > sum ) // we can not include it
 *     return subset(arr,sum,n-1)
 * if(arr[i]<=sum)// we have two choice either include it or leave.
 *    return subset(arr,sum-arr[n-1],n-1)||subset(arr,sum,n-1)// here we || because we have to return boolean;
 * 
 * //Now above problem is similar to knapsack 0-1
 * 
 * so conver it to the top down approach
 * 
 * First initialisation :
 *  for i to n
 *   for j to sum+1  
 *     if(i==0) false; 
 *       if(j==0) true;
 * 
 * Step 2 : 
 * // here i is n(which is arr[i]) and j is sum
 *   for i to n+1
 *      for j to sum + 1
 *          if(arr[i-1]<=j)
 *              dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j]
 *          else
 *              dp[i][j]=dp[i-1][j]
 * 
 * 
 * 
 */
public class Subset {
   
   static void subsetTopDown(int arr[], int n,int sum){

     boolean  dp[][]=new boolean[n+1][sum+1];
    // step 1 initialisation
    //Arrays.fill(dp,false);
  
    for (int i = 0; i < dp.length; i++) 
        for (int j = 0; j < dp[0].length; j++) 
            dp[i][j]=false; 

    for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[0].length; j++) {
            if(i==0) dp[i][j]=false;
            if(j==0) dp[i][j]=true;
           
        }
    }
   

    for (int i = 1; i < arr.length+1; i++) {
        for (int j = 1; j < sum+1; j++) {
            if(arr[i-1]<=j)
                         dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                      else
                          dp[i][j]=dp[i-1][j];
        }
    }

    System.out.println("Answer : " +dp[arr.length][sum]);

   }

    //  Count the number of subset for the given sum
    static void subsetCountTopDown(int arr[], int n,int sum){

        int  dp1[][]=new int[n+1][sum+1];
       // step 1 initialisation
       //Arrays.fill(dp,false);
     
       for (int i = 0; i < dp1.length; i++) 
           for (int j = 0; j < dp1[0].length; j++) 
           dp1[i][j]=0; 
   
       for (int i = 0; i < dp1.length; i++) {
           for (int j = 0; j < dp1[0].length; j++) {
               if(i==0) dp1[i][j]=0;
               if(j==0) dp1[i][j]=1;
              
           }
       }
      
   
       for (int i = 1; i < arr.length+1; i++) {
           for (int j = 1; j < sum+1; j++) {
               if(arr[i-1]<=j)
               dp1[i][j]=dp1[i-1][j-arr[i-1]]+dp1[i-1][j];// here we replace || with +
                         else
                         dp1[i][j]=dp1[i-1][j];
           }
       }
   
       System.out.println("Answer of total subset count : " +dp1[n][sum]);
   
      }

    public static void main(String[] args) {
        int arr[]=new int[]{10,3,3,13,4};
        int sum=16;
       
        subsetTopDown(arr, arr.length, sum);
        subsetCountTopDown(arr, arr.length, 3);

     
    }
    
}