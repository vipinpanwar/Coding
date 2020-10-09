import java.util.*;

/**
 * Problem : hacker rank problem : https://www.hackerrank.com/challenges/bear-and-steady-gene/problem
 * 
 * output : Print the length of the minimum length substring that can be replaced to make "gene" stable. 
 * Solution : 
 *    Here we can see it solution need minimum length substring , which help to identify this
 *   problem can be the sliding window proble.
 * 
 *   input : 8  
 *          str : GAAATAAA
 *     Here answer is 5 , 
 * One optimal solution is "AAATA" to replace with "TTCCG" resulting in "GTTCCGAA" .
 *          The replaced substring has length 5.
 * 
 * So here we need to find the min substring which we can replace to make the string 
 * stable.
 * 
 *  >> 1.) we can count the frequency of every character.
 *     2.) for this sliding window we use the two pointers , i and j both start with 0;
 *     3.) Now we check for all 4 characters , if they are stable ( frequency of all chars <= n/4) and (j < i)
 *        if yes we will  increase the frequency of jth character and then increment the j.
 * 
 *          if No : then we simply decrease the ith character and increment the i ,  
 *           
 *          At last we store the answer as, ans = min( i - j , ans);
 *  
 * 
 *
 */
import java.util.*;

public class BearAndSteady {

    static HashMap<Character , Integer> map = new HashMap<>();

    static boolean stable ( int n){
        if( map.getOrDefault('G' , 0) <= n && map.getOrDefault('T' , 0) <= n && map.getOrDefault('C' , 0) <= n && map.getOrDefault('A' , 0) <= n)
        return true;
        return false;
    }
    static int solve(String str , int n){
        int ans = Integer.MAX_VALUE;

        for( int i = 0, j = 0 ; i < str.length(); ){
            if(stable(n/4)){
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j),0) + 1);
                //System.out.println(" stable" + " i " + i + " j " + j);
                j++;
                if( j < i){
                int temp_ans = i - j +1;
                if(temp_ans > 0 )
                 ans = Math.min(ans ,  temp_ans);
                }
                if(i == j)
                ans = 0;
     
            }
            else{
                //System.out.println("not stable" + " i " + i + " j " + j);
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0) -1);
                i++;
               
            }
          

        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();
        String str = sc.next();
       // String str = "GAAATAAA";
        
       for (int i = 0; i < str.length() ; i++) {
           map.put(str.charAt(i) , map.getOrDefault(str.charAt(i), 0) + 1);
       }

     
        int ans = solve(str , str.length());
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
    
}
