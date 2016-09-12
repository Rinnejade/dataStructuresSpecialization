import java.util.*;

public class LCM {
  private static long lcm_naive(long a, long b) {
    for (long l = 1; l <= a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return a * b;
  }

  private static long lcm_fast(long a, long b) {
    return (a * b)/ gcd_fast(a,b);
  }

  private static long gcd_fast(long a, long b) {
    if(b==0)
      return a;
    return gcd_fast(b,a%b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
    // System.out.println(lcm_naive(a, b));
  }
}
