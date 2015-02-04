
public class Fibonacci {

	int firstFibonacci;
	int lastFibonacci;

	public Fibonacci(int first, int last) {

		firstFibonacci = first;
		lastFibonacci = last;
	}
	
	long fibonacciN (int n) {
		
		if(n < 1) { return 0;}
		else if(n == 1 || n == 2) { return 1;}
		else if(n > 2) { return fibonacciN(n - 1) + fibonacciN(n - 2);}
		
		return 0;
		
		};
	// calculates fibonacci numbers from interval	
	void calculateFibonacci(){
		long fibonacciN;
		for (int i = firstFibonacci; i <= lastFibonacci; i++) {
			fibonacciN = fibonacciN(i);
			System.out.print(fibonacciN + " ");
		}
	}
}
