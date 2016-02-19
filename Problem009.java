/*
Special Pythagorean triplet
Problem 9

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a² + b² = c²

For example, 3² + 4² = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

 */
package projecteuler;


public class Problem009 {
    public static void main(String[] args){
        
        // There are 3 equations and 3 variables
        // equation 1: a < b < c
        // equation 2: c² = a² + b² 
        // equation 3: c = 1000 - a - b     
        
        int a = 1;
        int b = 2;
        int c = 1000 - a -b;
        int answer = 0;
        
        outerloop:
        for(a = 1; a <= 997; a++){
            for(b = a + 1; b<=998; b++){    //equation 1
                c = 1000 - a - b;           //equation 3
                if( a*a + b*b == c*c ){     //equation 2
                  answer = a * b * c;
                  break outerloop;                 
                }
            }
        }         
        
        System.out.printf("a = %d, b = %d, c = %d %n" +
                          "%d + %d = %d %n" +
                          "answer: a*b*c = %d %n",
                          a,b,c,
                          a*a,b*b,c*c,
                          answer);
        
    }
}

/*
For plotting the solution quickly online:
eq 2 + eq 3: a² + b² = (1000 - a - b)²     
Solving that on Wolfram Alpha get us:
https://www.wolframalpha.com/input/?i=a^2%2Bb^2%3D%281000-a-b%29^2
a = 200, b = 375 and c = 425 
*/