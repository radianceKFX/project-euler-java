public class Timing
{
 public static void main(String args[])
 {
 	int sum = 0;
 	int i;
 	long start, stop;

 	start = System.currentTimeMillis();
 	for (i = 1; i <= 1000000; i = i+1) {
 	    sum = sum + i;
 	}
 	stop = System.currentTimeMillis();
 	System.out.println(stop-start);
 }
}

