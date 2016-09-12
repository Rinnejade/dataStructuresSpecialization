import java.util.Scanner;
import java.util.*;

public class PointsAndSegments {

    private static Boolean DEBUGG = false;
    private static void disp(ArrayList<Point> points){
        for(Point point:points)
            System.out.println(point.p + " " + point.type);
    }
    private static class Point{
        long p;
        char type;
        Point(long p, char type){
            this.type = type;
            this.p = p;
        }
    }
    public static class CustomComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            if(p1.p>p2.p)
                return 1;
            else if(p1.p<p2.p)
                return -1;
            //if equal l p r order sort
            else{
                if((p1.type=='p' && p2.type=='l') || (p1.type=='r' && p2.type=='p') || (p1.type=='r' && p2.type=='l'))
                    return 1;
                else if((p1.type=='l' && p2.type=='p') || (p1.type=='p' && p2.type=='r') || (p1.type=='l' && p2.type=='r') )
                    return -1;
                else 
                    return 0;
            }
        }
    }
    private static HashMap<Long, Integer> fastCountSegments(ArrayList<Point> points) {
        //write your code here
        if(DEBUGG)
            disp(points);
        HashMap<Long, Integer> pointCount = new HashMap<>();
        int count = 0;
        for(int i=0;i<points.size();i++){
            long p = points.get(i).p;
            char type = points.get(i).type;
            switch(type){
                case 'l' : count++; break;
                case 'r' : count--; break;
                case 'p' : pointCount.put(p,count); break;
            }
        }
        return pointCount;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        ArrayList<Point> points =  new ArrayList<Point>();
        n = scanner.nextInt();
        m = scanner.nextInt();
        long[] pointsArray = new long[m];
        for (int i = 0; i < n; i++) {
            points.add(new Point(scanner.nextLong(),'l'));
            points.add(new Point(scanner.nextLong(),'r'));
        }
        for (int i = 0; i < m; i++){
            long p =  scanner.nextLong();
            points.add(new Point(p,'p'));
            pointsArray[i]=p; 
        }
        Collections.sort(points, new CustomComparator());           
        HashMap<Long, Integer> pointCount = fastCountSegments(points);
        for (long x : pointsArray) {
            System.out.print(pointCount.get(x)+" ");
        }
    }
}

