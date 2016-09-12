import java.util.*;

public class FibonacciHuge {
    private static int  max = 100000;
    private static long[] f = new long[max];
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    
    private static long getPisano(long n){
        long a = 0;
        long b = 1%n;
        long res = 1;
        while(true){
            if((a==0&&b==0) || (a==1&&b==0))
                return res;
            res++;
            long d = a;
            a = b;
            b = (d+b)%n;
        }
    }
    private static int getFibonacciHugeFast(int n, long m) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (int)((tmp_previous + current)%m);
        }
        return current;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        long p = getPisano(m);
        int x = (int)(n%p);
        // System.out.println(x);
        long[] mem = new long[x+1];
        for (int i=1;i<=x;i++)
            mem[i] = -1;
        System.out.println(getFibonacciHugeFast(x, m));
        // System.out.println(getFibonacciHugeFast(x, m, mem));
        // System.out.println(getFibonacciHugeFaster(x)%m);
    }
}

