import java.util.*;


class Symbol{
    char symbol;
    int sign;//1->-,0->+
}
public class algebra {

    static void expression(String str){
        Stack stack=new Stack<Symbol>();
        String ans="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(')
            {   
                Symbol symbol=new Symbol();
                int sign=-1;
                if(!stack.isEmpty()){
                    Symbol prevSymbol=(Symbol)stack.peek();
                    sign=prevSymbol.sign;
                }
                if(i>0&&str.charAt(i-1)=='-')
                symbol.sign=sign==1?0:1;
                else symbol.sign=sign==1?1:0;
                symbol.symbol='(';
                stack.push(symbol);
            }
            else if(str.charAt(i)==')'){

                stack.pop();
            }
            else{
                int sign=0;
                if(!stack.isEmpty()){
                    Symbol symbol=(Symbol)stack.peek();
                    sign=symbol.sign;
                }
                if(sign==1){
                    if(str.charAt(i)=='-')
                    ans+='+';
                    else if(str.charAt(i)=='+')
                    ans+='-';
                    else ans+=str.charAt(i);
                }
                else{
                    ans+=str.charAt(i);
                }
                
                
            }

        }
   
        System.out.println("Answer : "+ans);


    }

    public static void main(String[] args) {
        String str="a-(b-c-(d+e-(x+z))-h)-f";
        expression(str);
    }


    
}