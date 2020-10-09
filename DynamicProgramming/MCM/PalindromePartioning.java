package MCM;
/**
 *  Problem : What is the minium number of parioning we can done to make every substring palindrome.
 * 
 * ex :  s = "akbh" Here we can see minimum number of partion is n-1 bcz every character is a palondrome
 *           and we donot have any sibstring palindrome here.
 *      s1 = nitin : here answer is 0 we do not have to partion bcz string it self is a palindrome
 *    
 *      s2 = nitim : here we have to do partition : n | iti | m --> so total partition is 2;
 * 
 *       SO this problem is a variation of MCM.
 *     
 * >>  : solve(str ,  0 , n-1);
 *    
 * >> bc : if(i >= j) return 0;
 * 
 * >>main logic : 
 * 
 *              if(isPalindrome(str , i-1 ,j)==true) return 0;
 *              for k=1 to k=j-1
 *               temp_ans =  solve(str , i , k ) + solve(str k+1 , j) + 1;    
 *                  
 *              ans = min ( ans , temp_ans);
 * 
 *          return ans;
 * 
 * 
 * 
 */
public class PalindromePartioning {

    static int dp[][] =new int[100][100];

    // "nitin" -> n=5 -> 1 == 5  , 2 == 4 ,3==3 || ,4==2 
    static boolean isPalindrome(String str , int start , int end){

        for (int i = start,j=end; i <= j ; i++ , j--) {
            //System.out.println( str.charAt(i) +"  "+ str.charAt(j));
            if( str.charAt(i) == str.charAt(j) )
            continue;
            return false;
        }

        return true;
    }

    static int partitionPalindrome(String str, int i, int j){
        //bc
        if(i>=j)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        //main logic
        if(isPalindrome(str, i, j)) return 0;

        for (int k = i; k <= j-1; k++) {
            int temp_ans = partitionPalindrome(str, i, k) + partitionPalindrome(str, k+1, j) +1;
            ans = Math.min(ans ,  temp_ans);
        }


        return dp[i][j] = ans;
    }


    public static void main(String[] args) {
     
        String str = "abc";

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println( " Answer is : "+ partitionPalindrome(str, 0, str.length()-1));

    }
}
