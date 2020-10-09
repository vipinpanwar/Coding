
/*
There are N people in city, who wants to visit Kingdom of Dreams. The road of reaching of Kingdom is not so safe. Therefore, they go to kingdom only in a security vehicle, which can accommodate at the most two people (There is only one security vehicle available in the town as it is quite costly and unique). People started to hire this vehicle to reach safely by driving it by themselves. Every part of journey from town to kingdom or from kingdom to town has some cost associated with it which is given by an array A[] elements. Array A[] has N elements, where A(i) represents the cost ith person has to pay if they travel alone in the vehicle. If two people travel in vehicle, the cost of travel will be the maximum of cost of two people. Calculate the minimum total cost so that all N people can reach Kingdom safely.

Input Format:
The first line contains, T, denoting the number of test cases. Each test case contains 2 lines each. The first line has an integer N, denoting the number of persons. Next line contains N space separated distinct integers denoting the cost of ith person.

Output Format:
For each test case, print the minimum cost required so that all people can reach kingdom.

Constraints:

1 ≤ T ≤ 10

1 ≤ N ≤ 100000

1 ≤ A[i] ≤ 1000000
****************************Solution***********************************

>>Very important thing we have to generalise the thing and use that .
case 1: First one cheapest go with costiest one and then comeback , and then same cheapest go with
       costiest one and come back ..  
       here total cost is = cost of two costiest one + 2*cheapest one.

case 2: First two cheapest will go and then cheapest among them  will come back, then two costiest one 
       will go and second cheapest will come back ... In this case total cost is 
       total cost : 2*cost of second cheapest + cost of first cheapest + cost of costest one 

       Take the some test case and test these... Very imp qn how to make different cases then generalise and 
       use them.     


*/
import java.util.*;
import java.io.*;

public class HackerRankKingdom {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            long answer = 0;
            while (n > 3) {
                answer = answer + Math.min(arr[0] + (2 * arr[1]) + arr[n - 1], (2 * arr[0]) + arr[n - 1] + arr[n - 2]);
                n = n - 2;
            }
            if (n == 3)
                answer = answer + arr[0] + arr[1] + arr[2];
            else if (n == 2)
                answer = answer + arr[1];
            else
                answer = answer + arr[0];
            System.out.println(answer);

        }

    }
}