/**
 *  Problem : Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
 * For example, given n = 3, a solution set is:
 *
 *  "((()))", "(()())", "(())()", "()(())", "()()()" 
 * 
 * 
 * 
 * 
 */
public class BalanceParanthesis {

 static void solve(int open , int close ,String op){
    //BC
    if(open == 0 && close == 0){
        System.out.println(op);
        return;
    }

    String op1 = op;
    String op2 = op;

    if(open > 0)
    {
        op1 +="(";
        solve(open -1 , close, op1);
    }
    if(close > open ) // open = 3 , close =3
    {
        op2 += ")";
        solve(open, close - 1, op2); 
    }

    }

    public static void main(String[] args) {
        int n = 3;
        int close = n;
        int open = n;
        String op = "";
        solve(open , close ,op);

    }
}
