import java.util.*;

public class LargestNumber {
    private static Boolean GreaterThanOrEqual(String a, String b){
        if(a.equals("0")) return true;
        String ab =a+b;
        String ba =b+a;
        return (ba.compareTo(ab))>=0?true:false;
    }
    private static String largestNumber(ArrayList<String> digits) {
        //write your code here
        String result = "";
        // digits.sort()
           
        while(digits.size()>0){
            String max = "0";
            for (int i = 0; i < digits.size(); i++) {
                if(GreaterThanOrEqual(max, digits.get(i)))
                    max = digits.get(i);
            }
                    // System.out.println(result);
                    result += max;
                    digits.remove(max);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> digits = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            digits.add(scanner.next());
        }
        System.out.println(largestNumber(digits));
    }
}

