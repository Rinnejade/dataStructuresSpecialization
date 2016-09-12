import java.util.*;

public class DotProduct {
    private static long maxDotProduct(ArrayList<Long> a, ArrayList<Long> b) {
        //write your code here
        long result = 0;
        Collections.sort(a);
        Collections.sort(b);
        while(a.size()>0) {
            Long a_cur = a.get(a.size()-1);
            Long b_cur = b.get(b.size()-1);
            // if((a_cur*b_cur)<0){    
                // b_cur = Collections.min(b); 
            // }
            // System.out.println(a_cur*b_cur);

            a.remove(Long.valueOf(a_cur));
            b.remove(Long.valueOf(b_cur));
            result += a_cur * b_cur;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Long> a = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextLong());
        }
        ArrayList<Long> b = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
            b.add(scanner.nextLong());
        }
        System.out.println(maxDotProduct(a, b));
    }
}

