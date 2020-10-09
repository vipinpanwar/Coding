/**
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. Output should be printed in sorted increasing order of strings.
 *
 *  Input:  str[] = "ABC"
 * Output: (A B C)(A BC)(AB C)(ABC)
 * 
 */

public class PermutationSpace {

    static void solve( String output , int n){
        //BC
        if( n >= output.length() - 1){
            System.out.println(output);
            return;
        }

        String op1 = output;
     
       
        String op2 = output.substring(0, n+1) + " " + output.substring(n+1);
       
        
        solve( op1 , n+1);
        solve(op2, n+2);
        
    }
    public static void main(String[] args) {
        String input = "AB";
        
        solve( input , 0);
        //System.out.println(input.substring(0 , 1));


    }
}
