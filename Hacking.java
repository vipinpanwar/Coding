/*  Problem statement :
Hacker and traffic lights Zolo is stuck in a traffic due to dysfunctional traffic light.
Zolo is a professional hacker and he can get into the system and change the state of the light.
His planet has different types of traffic lights such that there are N bulbs on the traffic board 
and only when all of them are green(G) the cars can pass. there are 2 other states also which the 
bulb can show; i.e. Red(R) & Yellow(Y). Note that the lights are designed such that they follow a state
change cyclic pattern as follows: R------>Y------>G------->R Once Zolo gets into the system he can select
any position i and update all elements between i to min(N, i + K - 1) by increasing their state by 1.This 
whole process takes 1 sec and he can repeat this process any no. of times until he gets all lights = G .
Find the minimum time to do the process as Zolo is getting late for work.
 
****************************************************Solution***********************************************
>>we traverse the string linearly and convert the color of the light to green and count the time.
>>At every index i we check that (i-k>=0) if yes then we update the temp, so that 

This problem is using sliding windows , 
    ex : RYGY if ( k = 2, n = 4)
    First what is the window size here it is : ( i + k -1) so ( i + 2 -1) or ( i + 1)
                        or
        If index start with zero then we can say , if(i - k >= 0){ window changed };

        RYGY , if convert R to G , then all other elements will also change their state as
        per given condition, For that we wil use Temp,

        Now What will happen when window changed or slide to the right ,
        then we have to reset the the number of transition Please see the code below for that.




*/

public class Hacking {

    static int getCount(int n,int k,int trafficLight[]){
        int temp = 0;
        int totalTime = 0;

        for(int i = 0; i < trafficLight.length; i++){
            if((temp + trafficLight[i])%3==0)
            trafficLight[i] = 0;//we added only 0 here in temp that's why we are assinging 0 same for others.
            else if((temp + trafficLight[i])%3==1){
                temp+=2;      
                totalTime+=2;
                trafficLight[i] = 2; // Why we are assigning to here , Because this 2 show number of time its state change, for ex here
                                    //  y -> g -> r ( 2 times.)
            }
            else if((temp + trafficLight[i])%3==2){
                temp+=1;
                totalTime+=1;
                trafficLight[i] = 1;
            }

            if(i-k>=0){
                temp=temp-trafficLight[i-k];
            }

        }

        return totalTime;
    }

    public static void main(String[] args) {
        int n = 4, k = 1;
        k--;//for(i+k-1)
        //int windowSize = (k - 1);
        String str="RYGY";
        int trafficLight[]=new int[str.length()];
        for(int i = 0; i < str.length() ; i++){
            if(str.charAt(i) == 'G')
            trafficLight[i] = 0;
            if(str.charAt(i) == 'R')
            trafficLight[i] = 1;
            if(str.charAt(i) == 'Y')
            trafficLight[i] = 2;
        }
        System.out.println(getCount(n,k,trafficLight));

    }

}