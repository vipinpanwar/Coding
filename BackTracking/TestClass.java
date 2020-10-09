

//import for Scanner and other utility classes
import java.util.*;


class TestClass {
    static long mod = 1000000007;
    static long solve(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1'){
                count++ ; 
            }

        }
        if(count % 2 == 1) return -1;
        int start = 0;
        int zero = 0;
        long ans =  1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') start = 1;
            if(str.charAt(i) == '1' && zero > 0){
                 ans = (ans * (zero+1)) % mod;
                 zero = 0;     
                }
            if(str.charAt(i) == '0' && start == 1){
                zero++;

            }
        }

        return ans;


    }

    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

       System.out.println( solve(str) );


    }
}


// if Patient mod 2 == 0 , Then count the number of 0 

//    ( 2 | 2 | 2) --> number of 0 = 3

// Answer  : (3 0 0) ( 0 3 0) ( 0 0 3) (1 1 1) (2 1 0) (2 0 1) (0 2 1) (1 2 0) (0 1 2)( 1 0 2)

// _ , _ , _ = 3

// x + y + z = 3 // 0>=(x,y,z)<=3