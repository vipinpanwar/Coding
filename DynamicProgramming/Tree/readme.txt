Identification : 

            1.) Tree traverseb, and in every node we are doing some operation, 
                then we should look for DP , and store it.

IN the tree DP Question There are three things : 

        solve( *root ){
               1.) BC

                2.) Hypothesis (fn calls)

                3.) Induction ( some logic)
        }

    syntax :
     int solve( node *root , int res){
         // BC  
         if( root == nullPtr)
            return 0;

        //Hypothesis
        int left = solve(root -> left , res);
        int right = solve( root->right , res);

       //Induction

        int temp_ans ;// calculate
          res = max( res , temp_ans)//something
        return temp_ans;
     }
