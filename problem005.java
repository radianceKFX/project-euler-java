/*
Smallest multiple
Problem 5

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

 */
package projecteuler;

public class problem005 {
    
    public static void main(String[] args){
        
        boolean remainder = true;
        int answer = 2520; //start here
        int count;     //this keeps track of times divided without remainder
        int target = 20;   //count should become this
        
        while(remainder){//loop while there is a remainder
            count = 0; //reset counter for each number
            for(int i = 1; i <= target; i++){
                if(answer%i==0){count++;}
            }
            if(count==target){remainder=false;}
            else{answer++;}
        }
        System.out.printf("The answer is %d %n",answer);
    }
}
