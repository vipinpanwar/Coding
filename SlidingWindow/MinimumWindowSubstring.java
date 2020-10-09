import java.util.*;

/**
 *  Problem : Leetcode ,Given a string S and a string T, find the minimum window in S which will 
 *  contain all the characters in T in complexity O(n).
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC" 
 * Output: "BANC"
 * 
 *  First store the frequency  here , A - > 1 b->1 c->  1
 * 
 * then use sliding window and if character find decrease its frequency,
 * 
 * Take i and j and then increment i if frequency is same is same for every string store the length(i - j);
 * and increment j till it reach to the character which is in the second string.
 * 
 * 2.) if not same increment i.
 * 
 */
public class MinimumWindowSubstring {
    static HashMap<Character , Integer> map = new HashMap<>();

    static boolean checkEqual(){

        for( Character key : map.keySet() ){
            if(map.get(key) > 0 )
            return false;

        }
        return true;
    }

    static String solve(String str1 , String str2){
        int index1 = 0;
        int index2 = 0;
        int min = Integer.MAX_VALUE;
       

        for( int i=0 , j=0; i< str1.length() ||  j < str1.length() ; ){
            if(checkEqual() && j < i && j < str1.length()){
                int temp = i - j + 1;
               
                if(temp > 0){
                   // System.out.println( "i " + i + " j " + j + " temp " + temp + " min " +  min);
                   if( temp < min){
                    index1 = j;
                    index2 = i;
                    min = temp;
                   }
                    //min = Math.min(temp , min);
                }
                map.put(str1.charAt(j), map.getOrDefault(str1.charAt(j), 0) + 1);
                //System.out.println(str1.charAt(j));
                j++;
                while( j < str1.length() &&!map.containsKey(str1.charAt(j))){
                   // System.out.println(str1.charAt(j));
                    j++;
                }
               

            }
            else if( i < str1.length()){
                
                if(map.containsKey(str1.charAt(i))){
                    map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i),0) - 1);   
                }
                i++;

            }
            else {
                if( j < str1.length() && map.containsKey(str1.charAt(j)) ){
                    map.put(str1.charAt(j), map.getOrDefault(str1.charAt(j),0) - 1);   
                }
                j++;
            }


        }

      return min == Integer.MAX_VALUE ? "" : str1.substring(index1,index2);
    }
    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "b";
       System.out.println("start");
        for (int i = 0; i < str2.length(); i++) {
            map.put(str2.charAt(i),map.getOrDefault(str2.charAt(i),0) + 1);
        }
       System.out.println( "Answer : " +solve(str1 , str2) );
       
    }
}
