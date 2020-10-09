package LCS;

/**
 * Problem :  Longest Commono Subsequnce
 *      input s1 : acbef   s1:aghbkf
 *            ans : abf length: 3
 * 
 * >>Recusive approach
 * Step 1 : base condtion
 * Think of smallest valid input.
 *   when length of s1 and s2 is 0 that is our base condtion;
 *  if(s1.lenght()==0||s2.length()==0)
 *    return 0;
 * 
 * >> Choice diagram
 * 
 * --> we will start from end and we have two choices either
 *    if both the char match then we increase the increment and 
 *   move to next character or if it does not match then either we
 *   take the take the FIRST whole string and second n-1 string or
 *   take the first n-1 char of string and second whole string.
 * 
 * 
 *--> Now 
 *      if(s1[n-1]==s1[m-1])
 *              return lcs(s1,s2,n-1,m-1)+1;
 *      else // not matching
 *              return max(lcs(s1,s2,n,m-1),lcs(s1,s2,n-1,m))
 * 
 * //convert it to memorisation or bottom up.
 * So we have to save the repetitive things..
 *  
 * 
 */

public class longestCommonSubsequence {
    static int dp[][]=new int[100][100];
    static int lcs(String s1 , String s2 , int n , int m){
        
        if(n==0||m==0)
            return 0;
        if(dp[n][m]!=-1)
                return dp[n][m];//memorization


        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m] = lcs(s1, s2, n-1, m-1) + 1;

        }
        else
        return dp[n][m] = Math.max(lcs(s1, s2, n-1, m), lcs(s1, s2, n, m-1));
    }


    static int lcsTopDown(String s1 , String s2 , int n , int m){

        // step 1 intialization
        int dp1[][] = new int[n+1][m+1];
        for (int i = 0; i <= dp1.length; i++) {
           for (int j = 0; j <= dp1[0].length; j++) {
               if( i==0 || j==0 )
               dp[i][j]=0;
           } 
        }
  // Choice diagram
        for (int i = 1; i < dp1.length; i++) {
            for (int j = 1; j < dp1[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp1[i][j] = dp1[i-1][j-1] + 1;
                else
                 dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-1]);

            }
        }


        return dp1[n][m];


    }

    //Longest Common Substring
    static int lcSubstring(String s1 , String s2 , int n , int m){

        
        // step 1 intialization
        int dp1[][] = new int[n+1][m+1];
        for (int i = 0; i <= dp1.length; i++) {
           for (int j = 0; j <= dp1[0].length; j++) {
               if( i==0 || j==0 )
               dp[i][j]=0;
           } 
        }
  // Choice diagram
  int ans=-1;
        for (int i = 1; i < dp1.length; i++) {
            for (int j = 1; j < dp1[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp1[i][j] = dp1[i-1][j-1] + 1;
                else
                 dp1[i][j] =0;
                 ans=Math.max(dp1[i][j], ans);

            }
        }


        return ans;

    }
    public static void main(String[] args) {


        String s1="vipin"; String s2="yyvikkpjdksisdsn";
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j]=-1;
            }
        }
       System.out.println("Answer : "+ lcs(s1, s2, s1.length(), s2.length()) );
       System.out.println("Answer Top Down : "+ lcsTopDown(s1, s2, s1.length(), s2.length()) );
       System.out.println("Answer Top Down (lcSubstring) : "+ lcSubstring(s1, s2, s1.length(), s2.length()) );
   
    }
    
}
