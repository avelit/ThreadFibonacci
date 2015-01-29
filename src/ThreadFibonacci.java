public class ThreadFibonacci extends Thread {

	int firstFibonacci;
	int lastFibonacci;

	public void run() {
		Fibonacci fib = new Fibonacci(firstFibonacci, lastFibonacci);
		fib.calculateFibonacci();
	}

	public ThreadFibonacci(int first, int last) {

		firstFibonacci = first;
		lastFibonacci = last;
	}
}
