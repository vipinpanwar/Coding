package LCS;
/**
 *  First : Print the LCS?
 * Ans  : Take two samll string create matrix solve it and analyze how we are going
 *      It should be easy.
 * 
 * ******************************************************
 *   Second  Problem :  Shortest Common Supersequence
 *  Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
 *  Examples:
 *
 *  Input:   str1 = "geek",  str2 = "eke"
 *  Output: "geeke" Print length = 5
 * 
 *  Solution : lenght(s1) + length(s2) - LCS
 *             4 + 3 - 2 = 5
 *              LCS = ek;
 *              eke + geek or geek + eke
 * 
 *  Problem , Print the superSequence.
 *            Take string 1 and string 2 in sequece and if counter any LCS
 *            character , leave it and remove that character from LCs.
 *    
 *   str1 = "geek",  str2 = "eke" , LCS = "ek"
 *          NOW Answer is : g_e__eke ans = geeke
 * 
 * **********************************************************
 *  Problem : Minimum number of deletions and insertions to transform one string into another
 *  Given two strings ‘str1’ and ‘str2’ of size m and n respectively. 
 *  The task is to remove/delete and insert minimum number of characters
 *  from/in str1 so as to transform it into str2. 
 *  It could be possible that the same character needs to be 
 *  removed/deleted from one point of str1 and inserted to some another point.
 *      Example:
 *      Input : str1 = "geeksforgeeks", str2 = "geeks"
 *      Output : Minimum Deletion = 8
 *               Minimum Insertion = 0 
 * Solution : min # of deletion =  Str1 - lcs , 13 - 5 =8
 *            min # of insertion =  Str2 - Lcs , 5 - 5 =0
 *      Exmple 2 :
 *              input :  str1 : "gehks" str2 : "geeks"
 *                 min deletions = 1 ,  Str1 - lcs , 5 - 4 =1;
 *                 min insertions = 1 , Str2 - Lcs , 5 - 4 =1;
 * 
 * ***********************************************************************
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 *Example :
 *     Input:"bbbab"   reverse : "babbb" so LCS : bbbb so length is 4
 *     Output:4   Palindromic subsequence is : "bbbb"
 *  Solution : here if we reverse the String and take LCS then we get Longest
 *             palindromic subsequence.
 * 
 *   Example : str1 : abhjab , Reverse  : abjhab 
 *                          lCS : abhab  or abjab So length is 5.
 * 
 * **************************************************************************
 *    Problem : Minimum number of deletions to make a string palindrome
 *      Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
 *      Examples :
 *
 *          Input : aebcbda
 *          Output : 2
 *          Remove characters 'e' and 'd'
 *          Resultant string will be 'abcba'
 *          which is a palindromic string
 * 
 *  Solution  : reverse String and take LCS, so input : "aebcbda" reverse : "adbcbea"
 *             LCS : abcba(length = 5) SO min # of deletion is : (lenght of str1 - LCS(input , reverse(input)));
 *              SO 7 - 5 = 2 which is answer.
 * 
 * **************************************************************************
 * Problem :  Given two strings X and Y, print the shortest string that has both X and Y as subsequences.
 *  If multiple shortest supersequence exists, print any one of them.
 *
 *Examples:
 * 
 *      Input: X = "AGGTAB",  Y = "GXTXAYB"
 *  Output: "AGXGTXAYB" OR "AGGXTXAYB" 
 *  OR Any string that represents shortest
 *  supersequence of X and Y
 *
 *  Input: X = "HELLO",  Y = "GEEK"
 *  Output: "GEHEKLLO" OR "GHEEKLLO"
 *  OR Any string that represents shortest 
 *  supersequence of X and Y
 * 
 * Solution : Go to Top problem same.
 * 
 * *****************************************************
 *  **Important
 *         Longest Repeating Subsequence
 *  Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 *  Example:
 * Input: str = "aab"
 *  Output: "a"
 *  The two subsequence are 'a'(first) and 'a' 
 * (second). Note that 'b' cannot be considered 
 *  as part of subsequence as it would be at same
 *  index in both.
 *   
 * Question is asking print longest subsequence which is repeating.
 *   example :  "abfdahbud"
 * 
 *    Here answer is : "ABD" as this is longest repeating subsequence which comes 2 times.
 * 
 * Solution : Here we have find LCS(input , input) , only difference is we have to 
 *            when ( i == j && str1[i] == str[j]) we have to ignore this case,
 *            for (int i = 1; i < dp1.length; i++) {
 *          for (int j = 1; j < dp1[0].length; j++) {
 *               if(s1.charAt(i-1) == s2.charAt(j-1) && i != j)// Only One difference
 *                   dp1[i][j] = dp1[i-1][j-1] + 1;
 *               else
 *                dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-1]);
 *
 *           }
 *       }
 * 
 * *******************************************************************************
 *              
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class LcsVariation {
    
}
