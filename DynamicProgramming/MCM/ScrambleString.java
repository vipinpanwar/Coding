package MCM;

import java.util.HashMap;

/**
 *  problem : we will get the two input string and if both string are scramble 
 *            then return true else return false.
 *    Scaramble String : we can break the string into the binary tree, no children should be empty
 *                       we can swap the children of any parant , then we get the one of the possible 
 *                       scramble string.
 *    Example s1 : "great" s2 : "rgeat"
 * 
 *                         "great"
 *                       
 *                 "gr"                  eat
 * 
 *           g           r       e            at
 *   after swapping children of "gr" it become rg  and if we do not swap the children of "eat"
 *   final string we have is "rgeat" which is scramble string of "great" .
 * 
 *   Now we have to look for the base condition : 
 *   1.) if length is not same then return false;
 *   2.) if ( lenght is 0 for both the string ) return true;
 *   3.) if(length is 1) then check the strring is same and return true if same else return false;
 * 
 *  
 * 
 *  Now main logic
 * 
 *   We have two cases :
 * 
 *  case 1 : we check the first part of the string A to last part of the String B.
 *           and last part of the string A to the first part of the string A.
 * 
 * case 2 :  we check the first part of the string A to first part of the String B.
 *           and last part of the string A to the last part of the string A.
 * 
 *  if either of the above case is true we return true;
 *    ex : great , rgeat  let take i = 2
 *       
 *     case 1 : solve ("gr" , "at") and solve("eat" , "rge")
 *    
 *     case 2 : solve("gr" , "rg") and solve("eat" , "eat")
 *    return (case1 || case2);
 *               
 *
 * case 1 : if( solve ( a.substr( 0 , i) , b.substr(n-i , i) )  && solve (a.substr(i , n-i) , b.substr(0 , n-i) );
 * 
 * case 2 : if( solve ( a.substr( 0 , i) , b.substr(0 , i) )  && solve (a.substr(i , n-i) , b.substr(i , n-i) );
 *  
 * 
 * 
 */

public class ScrambleString {

    static HashMap<String,Boolean> map = new HashMap<>();

    static String getKey( String a , String b){

        return a + "$" + b;
    }

    static String substr(String a, int index , int length){
        String b="";
        
        while(length != 0){
            b = b + a.charAt(index);
            index++;
            length--;

        }

        return b;
    }

    static boolean solve( String a , String b){
        if(a.length() != b.length() ) return false;
        if(a.equals(b) == true) return true;

        // for DP memoriazation;
        if(map.containsKey(getKey(a, b))){
            return map.get(getKey(a, b));
        }
        // if(a.length() ==1 && b.length()==1) 
        //    return a.equals(b);
        int n = a.length();
     for (int i = 1; i < n; i++) {

         boolean case1 = solve ( substr(a, 0 , i) , substr(b , n-i , i) )  && solve (substr(a, i , n-i) , substr(b, 0 , n-i) );
         boolean case2 = solve ( substr( a , 0 , i) , substr(b ,0 , i) )  && solve (substr( a ,i , n-i) , substr(b ,i , n-i) ) ;

         
         if( case1 || case2 ) return true;

     }
        map.put(getKey(a, b), false);
        return false;
    }

    
    public static void main(String[] args) {

        String a = "great";
        String b = "rgeat";
        //System.out.println(substr(a, 4, 1));
    
      System.out.println("Answer is : "+ solve(a, b));
        
    }
}
