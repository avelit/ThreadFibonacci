public class ThreadFibonacci extends Thread {

  private volatile int firstFibonacci;
  private volatile int lastFibonacci;

  public void run() {
    Fibonacci fib = new Fibonacci(firstFibonacci, lastFibonacci);
    fib.calculateFibonacci();
  }

  public ThreadFibonacci(int first, int last) {
    firstFibonacci = first;
    lastFibonacci = last;
  }
}
