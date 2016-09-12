import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static Boolean DEBUGG = false;

    private static void disp(int[] a, int start, int end){
        for (int i=start;i<=end ;i++ ) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    private static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static int[] partition3(int[] a, int l, int r) {
      // write your code her
        int x = a[l];
        int j = l;
        int k = l;
        for (int i=l+1;i<=r ;i++ ) {
            if(a[i] == x){
                k++;
                if(a[i]!=a[k])
                    swap(a, i, k);
            }
            else if(a[i] < x){
                j++;
                k++;
                swap(a, j, k);
                if(k!=i)
                    swap(a, i, j);
            }
        }
        swap(a, l, j);
        if(DEBUGG){
            System.out.println("Pivot  : " +  x);
            System.out.println("Start Index  : " +  l);
            System.out.println("End Index  : " +  r);
            System.out.println("end of less index : " +  j);
            System.out.println("end of same index : " +  k);
        }
        int m1 = j;
        int m2 = k;
        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        // System.out.println(a[k]);

        //partition 2
        // int m = partition2(a, l, r);
        // randomizedQuickSort(a, l, m - 1);
        // randomizedQuickSort(a, m + 1, r);

        //use partition3
        int[] m = partition3(a, l, r);
        if(DEBUGG){
            disp(a, 0, a.length-1);
            System.out.println("positions : "+m[0]+" "+ m[1]);
            disp(a, l, m[0] - 1);
            disp(a, m[1] + 1, r);
        }
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

