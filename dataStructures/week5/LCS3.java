import java.util.*;

public class LCS3 {

    private static Boolean DEBUGG = true;
    private static int maxThree(int a, int b, int c){
        return Math.max(Math.max(a, b), c);
    }
    private static void disp(int[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+ " ");
        System.out.println("");
    }
    private static int[] lcsString(int[][] LCS, int[] a,int[] b , int m, int n){
        int i=m, j=n;
        int len = LCS[m][n];
        int[] lcs = new int[len];
        while(i>0 && j>0){
            if(a[i-1]==b[j-1]){
                lcs[--len]= a[i-1];
                i--;j--;
            }
            else if(LCS[i-1][j] > LCS[i][j-1])
                i--;
            else
                j--;
        }
        // System.out.println(lcs);
        return lcs;
    }
    private static int lcs3(int[] a, int[] b, int[] c) {
        int m = a.length;
        int n = b.length;
        int o = c.length;
        int[][][] LCS = new int[m+1][n+1][o+1];
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                for(int k=1;k<=o;k++){
                    if((a[i-1] == b[j-1]) &&  (b[j-1] == c[k-1])){
                        LCS[i][j][k] = 1 + LCS[i-1][j-1][k-1];
                    }
                    else{
                        LCS[i][j][k] = maxThree(LCS[i-1][j][k], LCS[i][j-1][k], LCS[i][j][k-1]);
                    }
                }
        return LCS[m][n][o];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

