import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    private static double max  = Double.MAX_VALUE;
    private static Boolean DEBUGG  = false;

    public static void display(ArrayList<Point> points, int start , int end){
        for(int i=start;i<=end;i++){
                points.get(i).disp();
        }
    }
    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        // public int compareTo(Point o) {
        //     return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        // }
        public int compareTo(Point o) {
            return Long.signum(x - o.x);
        }
        double getDifference(Point p){
            double d = Math.sqrt(Math.pow((p.x-this.x), 2) + Math.pow((p.y-this.y), 2));
            return Math.abs(d);
        }
        void disp(){
            System.out.println(x+" "+y);
        }
    }

    public static class CustomComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return Long.signum(p1.y - p2.y);
        }
    }
    static double findStripCloset(ArrayList<Point> strip, double d){
        double min = d;
        for(int i=0;i<strip.size();i++){
            for(int j=i+1;j<strip.size() && (Math.abs(strip.get(i).y-strip.get(j).y) < min);j++){
                if(strip.get(i).getDifference(strip.get(j)) < min)
                    min = strip.get(i).getDifference(strip.get(j));
            }
        }
        return min;
    }
    static double minimalDistance(ArrayList<Point> points, int start, int end) {
        double ans = Double.POSITIVE_INFINITY;
        //write your code here
        if(start == end){
            return max;
        }
        if(start +1 == end){
            return points.get(start).getDifference(points.get(end));
        }
        int mid =  (start+end)/2;
        double leftd = minimalDistance(points, start, mid-1);
        double rightd = minimalDistance(points, mid, end);
        
        ans = Math.min(leftd, rightd);

        Point midPoint = points.get(mid);
        if(DEBUGG){
            System.out.print("MIDPOINT : ");
            midPoint.disp();
        }
        ArrayList<Point> strip = new ArrayList<>();
        for(int i=start;i<=end;i++){
            if(Math.abs(midPoint.x-points.get(i).x)<ans)
                strip.add(points.get(i));
        }
        Collections.sort(strip, new CustomComparator());
        // return ans;
        if(DEBUGG){
            System.out.println("Points : ");
            display(points, start, end);
            System.out.println("Strip : ");
            display(strip,0,strip.size()-1);
        }

        return min(ans, findStripCloset(strip, ans));
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(nextInt(), nextInt()));
        }

        Collections.sort(points);

        if(DEBUGG){
            System.out.println("POINTS : ");
            display(points,0,points.size()-1);
        }

        System.out.println(minimalDistance(points,0, points.size()-1));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");

    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
