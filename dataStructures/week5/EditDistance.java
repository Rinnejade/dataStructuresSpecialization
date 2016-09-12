import java.util.*;

class EditDistance {
  private static Boolean DEBUGG = false;
  private static int minThree(int a, int b, int c){
      return Math.min(Math.min(a, b), c);
  }
  private static void disp(int[][] mat, int m, int n){
      for(int i=0 ;i<m;i++){
          System.out.println("");
          for(int j=0;j<n;j++)
              System.out.print(mat[i][j]+"  ");
      }
      System.out.println("");
  }
  public static int EditDistance(String s, String t) {
    //write your code here
    int m = s.length(); 
    int n = t.length();
    int[][] D = new int[m+1][n+1];
    for(int i=0;i<=m;i++)
      D[i][0] = i;
    for(int i=0;i<=n;i++)
      D[0][i] = i;
    for(int i=1;i<=m;i++)
      for(int j=1;j<=n;j++){
        int match = D[i-1][j-1];
        int mismatch = D[i-1][j-1]+1;
        int del = D[i-1][j] + 1;
        int ins = D[i][j-1]+1;
        if(s.charAt(i-1)==t.charAt(j-1))
          D[i][j] = minThree(match, del, ins);
        else
          D[i][j] = minThree(mismatch, del, ins);
      }
    if(DEBUGG)
      disp(D,m+1,n+1);
    return D[m][n];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
