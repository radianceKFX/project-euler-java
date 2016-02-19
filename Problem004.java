/*
Largest palindrome product
Problem 4
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
 */
package projecteuler;

public class Problem004 {

    public static void main(String[] args){
        //numbers to multiply
        //start at highest possible values
        int a = 999;
        int b = 999;
        int c = 0; int x = 0; int y = 0;
        int answer = 0;

       for(int i = 0; 99 < a; i++,a-- ){
           for(int j = 0; 99 < b; j++,b-- ){
               c = a * b;
               if( isPalindrome(c) && c > answer ){
                   answer = c; x = a; y = b;
                   //Show all best guesses before the final answer
                   System.out.printf("%d = %d x %d | current best guess %d %n",c,a,b,answer);
               }
               //optional: print out the whole process for fun
               //Warning! It might take a few minutes
               //System.out.printf("%d = %d x %d | current best guess %d %n",c,a,b,answer);
           }
           b = 999; //reset the b value
       }
       System.out.printf("The answer is %d x %d = %d %n", x, y, answer);
    }

    public static boolean isPalindrome(int x){
        String s = String.valueOf(x);
        StringBuilder r = new StringBuilder(s);
        String t = r.reverse().toString(); //reverse it and convert to String
        return s.equals(t);
    }


    // ******** Alternative Palindrome check without auto String reverse ********
    public static boolean isPalindromeNoAutoStringReverse(int x){
        boolean check = true;
        String s = String.valueOf(x); //convert to string
        int l = s.length();
        int l2 = l;
        //if string length is odd, skip checking the middle character
        if( l%2!=0 ){l2--;} //it also makes l2 even.

        for(int i = 0; i < (l2/2); i++){
        //chatAt starts counting at 0 and ends at String.length()-1
        //see: https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
            if( s.charAt(0+i) != s.charAt(l-1-i) ){
                check = false;
            }
        }
        //if f(1+i) = (n-i), for all i is not stringlength/2, then "check = false"

        return check;
    }
}
