***************************Segment Tree*****************************************************

>> we use this mainly for update query.
>> For range sum query , we can use the array method where we save the running sum and 
   calculate the sum for particular range, but for update this is not viable.
>> Creating the Segment tree : O(n)
>> Finding the range sum for q Queries : O(logn)
>> Updating the segment tree : O(logn)

** Segment tree is a full binary tree, which means every node has a two children or 0 children
and every node has the 2 children till 2nd last level.
** There is n nodes which represent the every element of an array and total internal node is 
   n-1 so total node is 2n-1

** How many nodes we needed to convert the array of n into segment tree?
   >> least power of 2 which is >= 2n-1
   example : if n=5 then 2n-1=9
             if we choose 2^3=8 -> 8>=9 : false
             so we choose 2^4=16 -> 16>=9 true 
             least power of 2 which is >= 2n-9
             here 2^5 is wrong answer.
    note : segment tree take atmost "least power of 2 which is >= 2n-1" nodes;

** Height of seg tree  (h)= ceil(log(n+1)) here base is 2 // here n size of the original array.???
** Size of segment tree array :  ( 2^h -1)??

** last level can have vancat spaces.


    