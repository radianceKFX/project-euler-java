/*
Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
package projecteuler;

import java.util.Date;

public class ProjectEuler002 {
 
    public static void main (String[] args){
        
        //Extra: comparing the difference in calcution speed of different methods
        int limit = 4_000_000_00;  //sum values must stay below this number
        int fib = 0; //used as variable during calculations
        int nStart = 1;  //first n value, start counting here.
        
        long duration;
        
        System.out.println("n : fib : sum");
        //solve with formula
        Date startTime = new Date();
        int sumFormula = 0; //start counter at zero
        int n = nStart;
        while(fib < limit){ 
            fib = getFibonnaciFormula(n);
            if(fib%2==0){      //check if term is even
            sumFormula += fib;
            System.out.printf("%d : %d : %d %n",n,fib,sumFormula);
            }//only add term if even  
            n++;
            
        }
        
        Date endTime = new Date();
        duration = endTime.getTime()-startTime.getTime();
        System.out.printf("Sum of all even fibonacci numbers smaller than 4.000.000 %n "
                + "%d ,%n duration Formula: %d %n%n",sumFormula,duration);
        
        //solve with recursion
        startTime = new Date(); //reset "stopwatch"
        int sumRecursion = 0;   //start counter at zero

        n = nStart; //reset counter
        fib = 0;
        while(fib < limit){ 
            fib = getFibonnaciRecursive(n);
            if(fib%2==0){      //check if term is even
            sumRecursion += fib;}//only add term if even   
            n++;
        }
        
        endTime = new Date();
        duration = endTime.getTime()-startTime.getTime();
        System.out.printf("Sum of all even fibonacci numbers smaller than 4.000.000 %n"
                + "%d ,%n duration Recursion: %d %n%n",sumRecursion,duration);
        
        //Check if answers match
        String check;
        if(sumRecursion == sumFormula){
            check = "match";
        } else { check = "don't match";}
        System.out.println("the solutions of the formula and recursion " + check);
    
        // Direct recursive method
        startTime = new Date();
        int sum = 0;
        int a = 1;
        int b = 1;
        int c = 0;
        while (c < limit){
            c = a + b; //new term in fibonacci number series
            if (c%2==0){ //check if term is even
                sum += c;//add even terms to sum
            }
            a = b;
            b = c;
        }
        endTime = new Date();
        duration = endTime.getTime()-startTime.getTime();
        System.out.printf("Sum of all even fibonacci numbers smaller than 4.000.000 %n"
                + "%d ,%n duration Direct Recursion: %d %n%n",sum,duration);
        
        
    } 
    
    //Solving it recursively
    private static int getFibonnaciRecursive(int n){
        int fib;
        switch(n){
         case 0: 
             fib = 0;
             break;
         case 1:
             fib = 1;
             break;
         default:
             fib = getFibonnaciRecursive(n-1) 
                 + getFibonnaciRecursive(n-2);              
        }
        return fib;
    }
    
    //Solving it with the formula on this page
    //https://www.math.hmc.edu/funfacts/ffiles/10002.4-5.shtml
    private static int getFibonnaciFormula(int n){
        double Phi, phi, fib; //Using doubles during the calculation to avoid rounding errors
        Phi = (1 + Math.sqrt(5.0))/2; //The Golden Mean
        phi = -1/Phi;                 //an associated golden number
        
        fib = (Math.pow(Phi, n) - Math.pow(phi, n))/Math.sqrt(5.0);
        //now convert the double into an int
        return (int)Math.round(fib);
    }
}