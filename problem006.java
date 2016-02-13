/*
Sum square difference
Problem 6

The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 552 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

 */
package projecteuler;

public class problem006 {
    public static void main(String[] args){
        
        int a = squareOfSums(100);
        int b = sumOfSquares(100);
        int c = a - b;
        
        System.out.printf("square of sums = %d %n"
                         + "sum of squares = %d %n "
                         + "the difference = %d %n", a,b,c);
    }
    
    public static int sumOfSquares(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum = sum + ( i * i );
        }
        return sum;
    }
    
    public static int squareOfSums(int n){
        int x = 0;
        for(int i = 1; i <= n; i++){
            x += i;
        }
        return ( x * x );        
    }
}
