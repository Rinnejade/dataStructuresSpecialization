import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
   
    private static long getFibonacciLastDigitFast(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current);
        }
        return (current)%10;
    }
    private static long getFibonacciLastDigitFast(int n, long[] mem) {
        if(mem[n]!=-1) return mem[n];
        if (n <= 1)
            return n;
        mem[n] = (getFibonacciLastDigitFast(n - 1, mem) + getFibonacciLastDigitFast(n - 2, mem)) % 10;
        return mem[n];
    }
    private static long getFibonacciPartialSumFast(long from, long to){
        if(from==to){
            return getFibonacciLastDigitFast(from%60);
        }
        long m = getFibonacciLastDigitFast((from+1)%60);
        long n = getFibonacciLastDigitFast((to+2)%60);
        // System.out.println(m + " "+n);
        return ((n-m)%10+10)%10;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        // System.out.println(getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}

