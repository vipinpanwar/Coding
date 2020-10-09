/**
 *Print all permutations of a string keeping the sequence but changing cases.
 *
 *Examples:
 *
 *Input : ab
 *Output : AB Ab ab aB
 * Important : This method is kind of generic and can be used on many problems.
 */
public class CasePermutation {
    static void solve(String input, String output){
        if(input == ""){
            System.out.println(output);
            return;
        }
        String op1 = output;
        String op2 = output;

        op1 += input.charAt(0);
        op2 += input.toUpperCase().charAt(0);
        if(input.length() > 1)
        input = input.substring(1);
        else input= "";
        solve(input, op1);
        solve(input, op2);
    }

    public static void main(String[] args) {
        String input = "abc";
        String output = "";
        solve(input, output);
    }
    
}
