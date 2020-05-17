public class ApowerNmodulo{
   
//Problem : To calculate (a^n%modulo) where n can be 10e18 


    /*Soln: to Calculare a^n we have to use divide and conquer .
    if n is even divide it to two equal parts and if n is odd 
    first convert it to even (a*a^n-1) and call the recursive function.*/

    //Time Complexity : log(n).


    public static long aPowerNmodulo(long a,long n,long modulo){
        if(n==2)
            return (a*a)%modulo;
    
        if(n%2==0){

           long ret=aPowerNmodulo(a,n/2,modulo);
            return (ret*ret)%modulo;

        }
        else{

          long ret=aPowerNmodulo(a, (n-1)/2, modulo);
            return (ret*ret*a)%modulo;

        }  
     }
 
     public static void main(String args[]) {
       long  modulo=100;
       long  a=2;
       long n=20;
      System.out.println( aPowerNmodulo(a,n,modulo));

     }
 
 }