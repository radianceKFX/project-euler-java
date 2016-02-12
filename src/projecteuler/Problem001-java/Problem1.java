/*
 * Multiples of 3 or 5
 * Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
package projecteuler;

public class ProjectEuler001 
{        
    public static void main (String[] args){
        int sum = 0;
        for(int i = 1; i < 1000 ; i++){
            if(i%3==0 || i%5==0){   //if number is multiple of 3 OR 5...
               sum += i;            //add that number to the total sum
            }
        }
        System.out.println("ProjectEuler Challenge 1:");
        System.out.println(sum);
        System.out.println("is the sum of all natural numbers below 1000 that are multiples of 3 OR %");
    }
}