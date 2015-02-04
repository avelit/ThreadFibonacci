import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program
{
    
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
		
		int start = 1;
		int finish = numberFibonacci / 5;
		
		curTime = System.currentTimeMillis();
    	
		List<Thread> threads = new ArrayList<Thread>();
	    // We will create 500 threads
	    for (int i = 0; i < 5; i++) {
	      Runnable task = new ThreadFibonacci(start,finish);
	      Thread worker = new Thread(task);
	      // We can set the name of the thread
	      worker.setName(String.valueOf(i));
	      // Start the thread, never call method run() direct
	      worker.start();
	      // Remember the thread for later usage
	      threads.add(worker);
	      start = finish + 1;
	      finish = (i==3)?numberFibonacci:start + numberFibonacci / 5;
	    }

		try {
			for (Thread thread : threads) {
	    		// wait until threads die 
				thread.join();}
		} catch (final InterruptedException e) {
			e.printStackTrace();
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