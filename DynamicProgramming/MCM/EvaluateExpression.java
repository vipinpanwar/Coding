package MCM;

import java.util.HashMap;

/**
 *  Problem : Evaluate the number of ways to make a expression true;
 *  Input : expression String
 *  Example : Str = " F ^ T & T"
 *  How many ways we ca make this expression true;
 *  now -> (F ^ T) & T --> T (one way)
 *         ( F) ^ (T & T) ---> T (second way) 
 *         So we have two ways to make this expression true by adding brackets.
 * 
 *  Now similarity :
 *    One this a code variation of MCM.
 * 
 *  In MCM we call fn solve(arr/string , i , j ), value)
 *  but here we have to send one more parameter  (arr/string , i , j , value)let see for why
 *   this problem is special 
 * >> if we see, for number of ways if operator is |(or)
 *    we have two side lhs and rhs
 *   >>one way lhs(true) | rhs(false) --> true (one way)
 *   >>        lhs(false) | rhs(true) --> true (second way)
 *             lhs(true) | rhs(ture) --> true (third way)
 * 
 *    above we can see the according to operator we have to find
 *   the true and false for sub expression in order to find the total number
 *  of ways.
 * 
 *   ** SO third parameter is boolean which shows what we have to see (true or false)
 *  ** for original problem/expression(fn) this boolean value is always true;.
 * 
 *  
 *   So let see the base condition first :
 *  BC : Here when i > j that means it is invalid and we have to return false;
 *       if( i > j) return false;
 *       
 *      Second when i == j  
 *     if( value == true) return str[i] == T;
 *     if( value == false) return str[i] == F;
 * 
 * 
 *  >> Now main code : which is for loop ( IN MCM variation)
 *    
 *      step 1 : solve() for calling fn i should be 0. (which is either T/F).
 *      step 2 : j should be n-1, k goes upto j-1; because k only point to operator
 *    
 *  k loop
 *     for k=i+1 upto j-1 ; k+=2
 *     int left_true = solve(str , i , k-1 ,true);
 *     int left_false = solve(str , i , k-1 ,false);
 *     int right_true = solve(str , i , k+1 ,true);
 *     int right_false = solve(str , i , k+1 ,false);
 * 
 *   Now we have to find number of ways according to the operator : 
 *  
 *   >>   if(str[k] == '&'){
 *       if(value == true){
 *         ans = ans + left_true*right_true;
 *      }  
 *         else ans = ans + left_true*right_false + left_false*right_false + left_false*right_false;
 * 
 *      }
 * 
 * *************************Change into dp Memorization********************
 *  to see the dimension of the aray we have to see the parameter and then
 *  number of parameter which are changing are become the the dimension of the array;
 * 
 *   Here three parameter are changing i , j and value instead of making a three dimension 
 *   array we can go for hashmap. where key will  be combination of i, j and value for ex :
 *   i+j+value as string value will be Integer.
 * 
 * 
 */

public class EvaluateExpression {

    static HashMap<String,Integer> map = new HashMap<>();

    static String getKey(int i , int j , char ch){

        return Integer.toString(i) + Integer.toString(j) + ch ;


    }
    static int solve(String str , int i , int j, char value){

        int ans = 0;
    if( i > j) return 0;
    if(i == j) 
        if( str.charAt(i) == value) return 1;
             else return 0;

    if(map.size() > 0 ){
        String key = getKey(i,j,value);
        if(map.containsKey(key))
            return map.get(key);

    }
             //k loop

        for (int k = i+1; k <= j-1; k+=2) {
      int left_true = solve(str , i , k-1 ,'T');
      int left_false = solve(str , i , k-1 ,'F');
      int right_true = solve(str , k+1 , j ,'T');
      int right_false = solve(str , k+1 , j ,'F');

      if(str.charAt(k) == '^'){
        if(value == 'T')
        ans += left_false * right_true + left_true * right_false;
        else
        ans += left_false * right_false + left_true * right_true;
      }
      else if(str.charAt(k) == '&'){
        if(value == 'T')
        ans += left_true * right_true;
        else
        ans += left_false * right_false + left_true * right_false + left_false * right_true;
      }
      else if(str.charAt(k) == '|'){
        if(value == 'T')
        ans += left_true * right_false + left_false * right_true + left_true * right_true;
        else
        ans += left_false * right_false ;
    


      }  
            
 }


    map.put(getKey(i, j, value),ans);
     return ans;
    }

    public static void main(String[] args) {
        String str = "T^F|F";

        System.out.println(" Answer is : " + solve(str, 0, str.length() - 1, 'T'));
    
    
    }


}
