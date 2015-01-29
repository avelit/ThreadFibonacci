import java.util.Scanner;

public class Program
{
    static ThreadFibonacci threadFibonacci1;
    static ThreadFibonacci threadFibonacci2;
    
    public static void main(String[] args)
    {
    	System.out.flush();
    	System.out.println("Input number of Fibonacci");
    	
    	Scanner sc = new Scanner(System.in);
        int numberFibonacci = sc.nextInt();
        sc.close();
        
    	if (numberFibonacci < 1) {
    		System.out.println("no number. bye.");
			System.exit(0);
		}
    	
    	long curTime = System.currentTimeMillis();
    	
		Fibonacci fib = new Fibonacci(1, numberFibonacci);
		fib.calculateFibonacci();
 	
		long duration1 = System.currentTimeMillis() - curTime;
		
		System.out.println();
		System.out.println("duration 1 = " + duration1);
		
		int divider = numberFibonacci / 2;
		
		curTime = System.currentTimeMillis();
    	// let's create 2 thread
		threadFibonacci2 = new ThreadFibonacci(divider + 1,numberFibonacci);	
    	threadFibonacci2.start();					

    	threadFibonacci1 = new ThreadFibonacci(1,divider);	
    	threadFibonacci1.start();					
    	
    	// wait until both threads die 
    	while (threadFibonacci1.isAlive()||threadFibonacci2.isAlive()) {
			
		}
		long duration2 = System.currentTimeMillis() - curTime;
		System.out.println();
		System.out.println("duration 2 = " + duration2);

		String faster;
		if (duration1 < duration2) faster = "1"; else faster = "2";
		System.out.println("faster " + faster);
		
		System.out.println("end");
    }
}