/** Java solution to Project Euler Problem 14: Longest Collatz sequence

The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.SortedMap;

public class Problem014 {
     
     public static void main(String[] args){
        
        int max = 999_999;
        SortedSet<Integer> list = new TreeSet<>();
        SortedMap<Integer, Integer> answers = new TreeMap<>();
        
        //fill the check list with all the numbers 1 until max
        for(int i = 1; i<=max; i++){
            list.add(i);
        }
                
        //Collatz Sequence
        int n;
        int maxChain = 0; //initialize the maxChain check
        int targetN = 0;      //the number with the longest chain
        
        //start with the biggest numbers first
        for(int i = max; 1<i; i--){
            int chain = 1; //reset chain count at one, including starting term
            if(!list.contains(i)){
                //this number definitely does not have the longest chain
                //because it has been covered in a previous iteration
                //skip it
            }else{ n = i;
                while(n>1){
                    if(n%2==0){ n=n/2;   } //if n is even do thisl
                    else{       n=3*n+1; } //if n is  odd do this
                    chain++;
                    list.remove(n); //this number does not have to be check as 'n'
                }
                if(chain > maxChain){maxChain = chain; targetN = i;}
                answers.put(chain,i);
            } 
        }
        
             
        System.out.printf("*** The number %d has the longest chain of count %d ***%n%n",targetN, maxChain);
        
        System.out.printf("The number of iterations calculated %d %nThe number of list items left %d %n",answers.size(),list.size());
        
        System.out.println(answers.keySet());
        System.out.println("Target N: " + answers.lastKey());
        System.out.println("Max Chain: " + answers.get(answers.lastKey()));
   
    /***** Manual Check of Single Cases ******/
    /*
              int i = 910107; //817799;
              n = i;
            int chain = 1; //reset chain count at one, including starting term
            System.out.printf("%d, ",n);
                while(n>1){
                    if(n%2==0){ n=n/2;    //if n is even do this
                    System.out.printf("%d, ",n);}
                    else{       n=3*n+1;  //if n is  odd do this
                    System.out.printf("%d, ",n);}
                    chain++;                    
                }
                if(chain > maxChain){maxChain = chain; targetN = i;}
   
       System.out.printf("*** The number %d has the longest chain of count %d ***%n",targetN, maxChain);

    */



        
     }    

}
