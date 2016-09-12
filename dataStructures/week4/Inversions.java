import java.util.*;

public class Inversions {

    private static Boolean DEBUGG = false;
     private static void disp(int[] a, int start, int end){
        for (int i=start;i<end ;i++ ) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left+1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        int k = left;
        int i = left;
        int j = ave;
        
        if(DEBUGG)
            disp(a,left, right);

        while(i<ave && j<right){
            if(a[i] > a[j]){
                // numberOfInversions+=(j-i-k);
                if(DEBUGG)
                    System.out.println("j: " + j + " i : "+ i+ " k : "+ k);
                numberOfInversions+=(j-k);
                b[k++] = a[j++];
            }else
                b[k++] = a[i++];
        }
        while(i<ave) {
            b[k++] = a[i++];
            // numberOfInversions++;
        }
        while(j<right){
            b[k++] = a[j++];  
            // numberOfInversions++;
        } 
        k = left;
        while(k<right){
            a[k] = b[k++];
        }
        if(DEBUGG)
            System.out.println("numberOfInversions : "+ numberOfInversions);
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

