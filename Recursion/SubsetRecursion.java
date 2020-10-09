/** 
 * Problem : Given the string print all its subset.
 * 
 *   Soln is explained in the readme.txt .
 * 
 * 
 */
public class SubsetRecursion {

    static void solve(String input , String output){
        if(input == "" || input.length() == 0){
            System.out.println(output);
            return ;
        }
        String op1 = output; // leave it.
        String op2 = output + input.charAt(0);// take it
        if(input.length() == 1){
            input = "";
        }
        else{
            input = input.substring(1);
        }
        solve(input, op1);
        solve(input, op2);


    }
   public static void main(String[] args) {
       String input = "abc";
       String output = "";
       solve(input  , output);
   } 
}
