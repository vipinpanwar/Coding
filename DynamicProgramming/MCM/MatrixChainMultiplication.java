package MCM;


/**
 *  ***********Identification*****************************
 * 1.) Input is string or array and we have to break it like 
 * 
 *       i....................j
 *  we break it i to k and then k+1 to j then we shift k and i and j
 *  remains same. 
 * 
 *  >> With every change in k we get the temp answer that is
 *    temp1, temp2.....
 * >> Then we take the optimal like max,min
 * 
 * >> second we have to make base condition 
 * >> For base condition we have to think of samllest valid or
 *   invalid condition.
 * 
 * >>In this let think of invalid condition so .. if when i>j
 *   then inpput become invalid.
 * 
 * ........................
 *   int solve(arr,i,j)
 *         if(i>j) return 0
 *      for k=i to j
 *     temp=    solve(i,k) (+/-/*)(Depending on Qn)  solve(k+1,j);
 *     ans=max/min(ans,temp);           
 * 
 * 
 * ********************MCM*******************************************
 * Basics : if matrix1 is row1 * col1 and matrix2 is row2 * col2
 *          a.) then  row2 == col1 (must condition)
 *          b.) total cost or number of multiplication : row1 * col1 * col2 or row1 * row2 * col2 
 *          c.) Final matrix after multiplication is row1 * col2;
 * 
 *   INPUT : arr [] = {40 , 20 , 30  , 10 , 30} here size = 5
 *    here input shows we have (size - 1) number of matrix;
 *    A1 = 40 * 20 , A2 = 20 * 30 , A3 = 30 * 10 , A4 = 10 * 30;
 * 
 *  here we can see Ai = arr[i-1]*arr[i]; i>0 Matrix Dimesions
 * 
 * // In above we have like :
 *   ((A1*A2)*A3)*A4) or (A1*A2)*(A3*A4) .......
 * 
 * >> we will get temp answer which are total cost of  ((A1*A2)*A3)*A4) or (A1*A2)*(A3*A4)..
 *    Then I will slect min of them.
 * 
 * 
 * 
 */

public class MatrixChainMultiplication {
   
    static int dp[][] = new int[1000][1000];

    static int solveMcm(int arr[] , int i , int j){
         int ans = Integer.MAX_VALUE;
      //base condition
      // here if i==j then we are on the same matrix which is also invalid.
     if(i>=j)
         return 0;         
         int temp_ans = 0;
    if(dp[i][j] != -1) 
         return dp[i][j];
        
     for (int k = i; k <= j-1 ; k++) {
          temp_ans =   solveMcm(arr, i, k) + solveMcm(arr, k+1, j) + ( arr[i-1] * arr[k] * arr[j] );
          // The reason for arr[i-1] * arr[k] * arr[j]  is let divide matrix in to two parts.. 
          // 1. 40 , 20 ,30 (i to k)  30 , 10 , 30 (k+1,j) First the cost of matrix multiplication is  row1 * col1 * col2 
          // and final matrix is row1 * col2 so above 40(which is at 0 index ) will become row 1 and 30 ( which is at last index)
          // will become col2 so k will become the common thing which is col1 or row1 because k-1 is col1 and k is row 1. 
           ans  = Math.min(temp_ans , ans);

     }   
     
     return dp[i][j] = ans;

    }
    public static void main(String[] args) {
        

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;

            }
        }


        int arr[]=new int[]{ 40 , 20 ,30 , 10 , 30 };
        //here we have to send i and j, i should be start form 1 bcz
        // Ai = A[i-1] * A[i]; so i should be 1; another thing j , we should 
        // selct j 
        System.out.println( "MCM Answer : " + solveMcm(arr, 1, arr.length-1) );

    }
}
