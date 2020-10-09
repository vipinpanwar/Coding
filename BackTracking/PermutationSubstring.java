/**
 *  problem : Given the string , print all permutation of the given string.
 * 
 *  input : s = "ABC";
 *  output : "ABC" , "ACB" , "BAC", "BCA" , "CAB"
 * 
 *  Here we can create the recursion tree, If we take the small string "AB"
 *                          
 *                                          "AB" //initial count 1,1 , level = 0; first we select A, so o/p ="A"
 * 
 * level:1, count 0,1 o/p="A"       "AB"              "AB" count 1 , 0, o/p="B"
 * 
 * level:2 count 0,0 o/p="AB"   "AB"               "AB" count 0,0 , o/p "BA";
 * 
 * 
 * Above we can see we are tracking the , level , count and o/p string , when o/p string length become equals
 * to the given string then we print the output string.
 * 
 *  
 */

public class PermutationSubstring {

    static void solve(String str , int level , Integer []count , char []output){

        //BC
        if(level == str.length()){
            System.out.println(output);
            return;
        }

     
       
        for (int i = 0; i < str.length(); i++) {
            if(count[str.charAt(i) - 'A'] == 0)
            continue;
            output[level] = str.charAt(i);
           // System.out.println(" level = " + level + " count " + count[0]);
      
            count[i]--;
            Integer c[] = count.clone();
            //level +=1;
            solve(str, level + 1, count, output);
            count[i]++;

        }
       

    }

   
   public static void main(String[] args) {
       String str = "AB";
       Integer count[] = new Integer[str.length()];
       for (int i = 0; i < count.length; i++) {
           count[i] = 1;
       }
       char output[] = new char[str.length()];

      solve(str , 0 , count , output);
      //check(count , 0);

       
   } 
}
