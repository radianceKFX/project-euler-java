/*  This Maths class is used for Project Euler

    The more accurate long primitive types are used for the primary algoritm.
    The methods for the int types just use casting. Explanation on casting:
    http://www.studytonight.com/java/type-casting-in-java
 */
package projecteuler;

public final class Maths {
    
    private Maths(){        
    }
 
    //Checks whether a long is prime or not.
    //http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
    //but added corrections. 
    public static boolean isPrime(long n) {
        if(n==1){return false;} //Added correction: 1 is not a prime.
        else if(n==2 || n==3){return true;}//Added correction: 2 and 3 are also a prime.
        //The algoritm below doesn't work for values lower than 4.
        //Check if n is a multiple of 2.
        else if (n%2==0){return false;}
        //If not, then just check the odds, up until the square root of n.
        //Note that the number 3 itself has already been checked.
        else{
            for(long i=3;i*i<=n;i+=2) {
               if(n%i==0)
                   return false;
            }
        }
        return true;
    }
    
    public static boolean isPrime(int n) {
        long nLong = n;
        return isPrime(nLong);   
    }
    
    //Checks the number of divisors of a long 1 'n'
    //A divisor of n is a number that can divide n without leaving any remainders.
    //Note: 1 and n itself are also divisors of n.
    //Negative integers might also be seen as divisors of n, but they are ignored here.
    //But they are identical to the positive divisors, except for the sign (-/+).
    public static long countPositiveDivisors(long n) {
        if(n < 0){n = -n;} //Make sure n is possitive 
        long count = 0; //the number of divisors
        long sum = 0;   //triangle
        double sqrtNdown = (double)((long)Math.sqrt(n)); //Rounded down square root of N
        
        //---------Explanation of the Math---------//
        //Every division has three parts.
        //Assuming c > b => a
        //and all are positive integers, then
        // c/b=a; or c/a=b;
        // If a is the small divider, b is the big divider.
        //The maximum value for a is sqrt(c).
        //So if we find an 'a' < sqrt(c) there is a guaranteed 'b' too.
        //In this case "count 'a' twice".
        //In case sqrt(c)==a==b then we should only "count 'a' once".
        //-----------------------------------------//
        
        //For divisors from 1 up to below squareroot of n, count them double.
        for(long i=1; i<Math.sqrt(n); i++) {
            if(n%i==0){ count += 2; }
        }
        
        //If n is exactly "square rootable" then only count the divisor 'a' once
        //This also includes n=1, which is also not accounted for in the for-loop.
        if(Math.sqrt(n)==sqrtNdown){count++;}
        
        return count;
    }            
    
    public static int countPositiveDivisors(int n) {
        long nLong = n;
        return (int)countPositiveDivisors(nLong);
    }
    

}