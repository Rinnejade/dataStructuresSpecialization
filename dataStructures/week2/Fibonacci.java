import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

     return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long calc_fib_fast(int n, long[] mem) {
    if(mem[n]!=-1) return mem[n];
    if (n <= 1)
      return n;

     mem[n] = calc_fib_fast(n - 1, mem) + calc_fib_fast(n - 2, mem);
     return mem[n];
  }
  
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long[] mem = new long[n+1];
    for (int i=1;i<=n ;i++ )
        mem[i] = -1;      
    System.out.println(calc_fib_fast(n, mem));
    // System.out.println("Slow : "+calc_fib(n));
  }
}
