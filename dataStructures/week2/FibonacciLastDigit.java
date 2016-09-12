import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    private static long getFibonacciLastDigitFast(int n, long[] mem) {
        if(mem[n]!=-1) return mem[n];
        if (n <= 1)
            return n;
        mem[n] = (getFibonacciLastDigitFast(n - 1, mem) + getFibonacciLastDigitFast(n - 2, mem)) % 10;
        return mem[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        n = n % 60;
        long[] mem = new long[n+1];
        // last digit of a fibanocci number repeats itself after 60 digits
        for(int i=1;i<=n ;i++ )
            mem[i] = -1; 
        System.out.println(getFibonacciLastDigitFast(n, mem));
        // System.out.println(getFibonacciLastDigitNaive(n));
    }
}

