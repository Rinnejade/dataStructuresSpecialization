import java.util.*;
import java.io.*;

public class MajorityElement {

    private static int getMajorityElementFaster(int[] a) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x: a ) {
            if(set.contains(x)){
                map.put(x, map.get(x) + 1);
            }
            else{
                set.add(x);
                map.put(x,1);
            }
        }
        for(int x : set)            
            if(map.get(x)>(a.length/2))
                return 1;
        return -1;
    }

    private static int getMajorityElement(int[] a, int left, int right) {
        // if (left == right) {
            // return -1;
        // }
        if (left == right) {
            return a[left];
        }
        int mid = right/2;
        // int l  = getMajorityElement(a,left,mid);
        // int r = getMajorityElement(a,mid,right);
        // if(l == r)
            // return left;
        //write your code here
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // if (getMajorityElement(a, 0, a.length-1) != -1) {
        if (getMajorityElementFaster(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

