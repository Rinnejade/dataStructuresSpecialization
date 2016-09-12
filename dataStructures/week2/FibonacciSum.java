import java.util.*;

public class FibonacciSum {
	// private static int mod_60 = 5;
  	private static long getFibonacciLastDigitTwoFast(int n, long[] mem) {
        if(mem[n]!=-1) return mem[n];
        if (n <= 1)
            return n;
        mem[n] = (getFibonacciLastDigitTwoFast(n - 1, mem) + getFibonacciLastDigitTwoFast(n - 2, mem)) % 100;
        return mem[n];
    }
    private static int getFibonacciSumFast(long n){
    	int m = (int)((n+2)%60 + 60) % 60;
        long[] mem = new long[m+1];
    	for (int i=1;i<=m ;i++ )
        	mem[i] = -1;
        int res = (int)getFibonacciLastDigitTwoFast(m, mem);
        return (res-1)%10;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int c = getFibonacciSumFast(n);
        System.out.println(c);
    }
}

