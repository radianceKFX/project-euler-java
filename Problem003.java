/*
The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
 */
package projecteuler;

public class Problem003 {
    public static void main(String[] args){
        long x,y;
        x = 600851475143L;
        boolean isPrime = true;
        //start with the biggest numbers first to prevent unnecessary calculations.
        //the biggest possible value cannot be greater than twice the size of the total
        //so start calculating there first
        int j = 2;
        for(long i = x/j; 0 < i; j++,i=x/j){
            if(x%i==0){
                y = i;

            if(Maths.isPrime(y)==true){
                int k = j - 1;
                System.out.println("answer = " + y + " | at iteration " + k);
                break;} //stop immediately when the number found!
            }
        }
    }

//    public static boolean isPrime(long l){
//        // On a math website it was explained that the prime factors of a number could not exceed the squared-root of that number.
//        boolean prime = true;
//        for(long i = 2; i < Math.sqrt(l);i++){
//            if(l%i==0){
//                prime = false;
//            }//if not divisble by i then keep prime true
//        }
//        return prime;
//    }
}
