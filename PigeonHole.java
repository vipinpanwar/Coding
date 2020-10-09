/* Problem : Pigeon hole problem find a number k which is divided by number n and consist only 0 or 1.
 
n pigeons we have to find m hole.
Soln : If there is two number divided by a number n and have same reminder then there absolute
       difference is always divided by n.

       here we have to find reminder of numbers: 1,11,111,1111....
       case 1: if any number mod n is 0 stop and print that number.
       case 2: we have initialize rem array and save reminder in this array if any number's
               reminder repeated we have to subtract both of them and print it.
*/

public class PigeonHole{

    public static void findNumber(int n){
        int number =0;
        int rem_array[]=new int[n+1];

        for(int i=1;i<=n;i++){

            number=number*10+1;
            int rem=number%n;
            if(rem==0){
                for(int j=1;j<=i;j++)
                    System.out.print(1); 
                    return;   
            }
            else{
                if(rem_array[rem]!=0){
                    for(int j=1;j<=i-rem_array[rem];j++)
                        System.out.print(1);
                    for(int j=1;j<=rem_array[rem];j++)
                        System.out.print(0);
                        return;
                }
            
            }
            rem_array[rem]=i;//saving the number of 1;
        }




    }

    public static void main(String[] args) {
        int n=7;
        findNumber(n);


    }











}