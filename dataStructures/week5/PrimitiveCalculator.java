import java.util.*;

public class PrimitiveCalculator {
    private static Boolean DEBUGG = true;
    private static int minThree(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }
    private static int findMin(int[][] a, int j){
        int min = Math.min(Math.min(a[1][j], a[2][j]), a[3][j]);
        if(min==a[1][j]) return 1;
        else if(min==a[2][j]) return 2;
        else return 3;
    }
    private static void disp(int[][] mat, int m, int n){
        for(int i=0 ;i<m;i++){
            System.out.println("");
            for(int j=0;j<n;j++)
                System.out.print(mat[i][j]+"\t");
        }
    }
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    private static List<Integer> optimal_sequence_faster(int n) {
            int[][] opsValues = new int[4][n+1];
            for(int j=1;j<=n ;j++)
                opsValues[1][j]=j-1;
            for(int i=2;i<4 ;i++) {
                for(int j=2;j<=n ;j++ ) {
                        if((i>=3) && j%i == 0 && j%(i-1) == 0)
                            opsValues[i][j] = Math.min(opsValues[i][j/2], opsValues[i][j/3]) + 1;
                        else if(j%i==0)
                            opsValues[i][j] = opsValues[i][j/i]+1;
                        else
                            opsValues[i][j] = minThree(opsValues[i-1][j], opsValues[i][j-1], opsValues[i-1][j-1])+1;
                }           
            }
            if(DEBUGG)
                disp(opsValues, 4, n+1);
            List<Integer> sequence = new ArrayList<Integer>();
            int j = n;
            while(j!=0){
                sequence.add(j);
                int min = findMin(opsValues, j);
                if(DEBUGG)
                System.out.println("vlaue : "+ j + " next : "+min);
                if(min==1)
                    j--;
                else if(min==2)
                    j/=2;
                else
                    j/=3;
            }
            return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // List<Integer> sequence = optimal_sequence(n);
        List<Integer> sequence = optimal_sequence_faster(n);
        System.out.println(sequence.size()-1);
        // System.out.println(sequence.size() - 1);
        Collections.reverse(sequence);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

