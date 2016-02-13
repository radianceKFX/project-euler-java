/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

public class Mathematics {

    //checks whether an int is prime or not.
    //http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
    //but added corrections. 
    public boolean isPrime(int n) {
        if(n==1){return false;} //added correction: 1 is not a prime
        else if(n==2 || n==3){return true;}//added correction: 2 and 3 are also a prime
        //the algoritm below doesn't work for values lower than 4
        //check if n is a multiple of 2
        else if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    //same algorith as above, but for long instead of int
    public boolean isPrime(long n) {
        if(n==1){return false;} //added correction: 1 is not a prime
        else if(n==2 || n==3){return true;}//added correction: 2 and 3 are also a prime
        //the algoritm below doesn't work for values lower than 4
        //check if n is a multiple of 2
        else if (n%2==0) return false;
        //if not, then just check the odds
        for(long i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}