/*
10001st prime
Problem 7

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */
package projecteuler;

public class problem007 {
    public static void main(String[] args){
        
        Mathematics calc = new Mathematics();
        int count = 0;
        int target = 10_001;
        int answer = 0;     // This project still has erors. Doesn't calculate primes correctly
        
        while(count != target){
            answer++;
            if( calc.isPrime(answer) ){
                count++;       
                //testing algoritm
                if( answer < 150 ){
                    System.out.printf("found prime %d, %f %n", answer, Math.sqrt(answer));
                }
            }
            
        }
        System.out.printf("The 10.001st prime number is %d %n", answer);
    }    
}
