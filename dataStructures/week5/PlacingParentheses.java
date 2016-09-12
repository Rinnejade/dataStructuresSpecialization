import java.util.Scanner;

public class PlacingParentheses {
    private static Boolean DEBUGG = false;
    private static Long minimum(Long min, Long a, Long b, Long c, Long d){
        return Math.min(Math.min(Math.min(Math.min(a, b), c), d), min);
    }
    private static Long maximum(Long max, Long a, Long b, Long c, Long d){
        return Math.max(Math.max(Math.max(Math.max(a, b), c), d), max);
    }
    private static void disp(Long[][] mat, int m, int n){
        for(int i=0 ;i<m;i++){
            System.out.println("");
            for(int j=0;j<n;j++)
                System.out.print(mat[i][j]+"\t");
        }
    }
    static class Result{
        Long res1;
        Long res2;
        Result(Long a, Long b) 
        //: res1(a), res2(b) {}; 
        {
            res1 = a; res2 = b;
        }
    }
    private static Result MinAndMax(int i, int j, String exp, Long[][] M, Long[][] m){
        Long min = Long.MAX_VALUE;
        Long max = Long.MIN_VALUE;
        for(int k=i;k<j;k++){
            Long a = eval(M[i][k], M[k+1][j], exp.charAt(2*k+1));
            Long d = eval(m[i][k], m[k+1][j], exp.charAt(2*k+1));
            Long b = eval(M[i][k], m[k+1][j], exp.charAt(2*k+1));
            Long c = eval(m[i][k], M[k+1][j], exp.charAt(2*k+1));
            min = minimum(min, a, b, c, d);
            max = maximum(max, a, b, c, d);
        }
        return new Result(max, min);
    }
    private static long getMaximValue(String exp) {
      //write your code here
        int n = (exp.length()+1)/2;
        // System.out.println(n);
        Long[][] M = new Long[n][n];
        Long[][] m = new Long[n][n];
        for(int i=0;i<n;i++)
            M[i][i]=m[i][i]=Long.parseLong(exp.charAt(2*i)+""); 
        for(int s = 0; s<n ; s++)
            for(int i=0; i<(n-s) ; i++){
                int j = i+s;
                if(j==i) continue;
                Result res = MinAndMax(i, j, exp, M, m);
                M[i][j]= res.res1;
                m[i][j]= res.res2;
            }

        if(DEBUGG){
            disp(M,n,n);
            disp(m,n,n);
        }

        return M[0][n-1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

