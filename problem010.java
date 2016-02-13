/*
Summation of primes
Problem 10

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.

 */
package projecteuler;

public class problem010 {
    public static void main(String[] args){
        
        Mathematics calc = new Mathematics();        
        int limit = 2_000_000; //stay below this limit
        long sum = 0; /*if you use int, it just loops back to its negative limit
                        because the sum is too big*/
        
        for(long i = 1; i < limit; i++){
            if(calc.isPrime(i)){
                sum += i;
                //System.out.println(i + " : " + sum); mainly used for debugging
            }
        }
        System.out.println("Answer: " + sum);
    }
}
