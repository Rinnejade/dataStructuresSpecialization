import java.util.*;

public class Knapsack {
    private static Boolean DEBUGG = false;
    private static void disp(int[][] mat, int m, int n ){
        for(int i=0 ;i<m;i++){
            System.out.println("");
            for(int j=0;j<n;j++)
                System.out.print(mat[i][j]+"\t");
        }
    }
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }
        return result;
    }
    static int optimalWeightFaster(int W, int[] w) {
        //write you code here
        int n = w.length;
        int[][] value = new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                value[i][j] = value[i-1][j];
                if(w[i-1]<=j){
                    int val = value[i-1][j-w[i-1]] + w[i-1];
                    if(value[i][j]<val)
                        value[i][j] = val;
                }
            }
        }
        if(DEBUGG){
            disp(value,n+1,W+1);
            for(int x:w)
                System.out.println(x+" ");
        }
        return value[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        // System.out.println(optimalWeight(W, w));
        System.out.println(optimalWeightFaster(W, w));
    }
}

