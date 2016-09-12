import java.util.*;

public class CoveringSegments{

    private static Boolean DEBUGG = true;

    private static ArrayList<Long> optimalPoints(ArrayList<Segment> segments) {
        //write your code here
        
        // for (int i=0;i<segments.size() ;i++ ) {
        //     System.out.print(segments.get(i).start +" ");
        //     System.out.println(segments.get(i).end);
        // }
        ArrayList<Long> points = new ArrayList<Long>();
        Long minRight = segments.get(0).end;
        points.add(minRight);
        
        for(int i=1;i<segments.size();i++) {
            Segment segment = segments.get(i);
            if(segment.start<=minRight && segment.end >= minRight)
                continue;
            else{
                minRight = segment.end;
                points.add(minRight);                
            }    

        }
        return points;
    }
    private static class Segment{
        Long start, end;
        Segment(Long start, Long end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class MyComparator implements Comparator<Segment> {
        @Override
        public int compare(Segment o1, Segment o2) {
            if (o1.end > o2.end)
                 return 1;
            else if(o1.end < o2.end)
                return -1;
            return 0;    
        } 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // Segment[] segments = new Segment[n];
        ArrayList<Segment> segments = new ArrayList<Segment>();
        for (int i = 0; i < n; i++) {
            Long start, end;
            start = scanner.nextLong();
            end = scanner.nextLong();
            segments.add(new Segment(start, end));
        }
        if(DEBUGG)
            for(Segment s: segments)
                System.out.println(s.start + " "+ s.end);
        

        Collections.sort(segments, new MyComparator());
        
        if(DEBUGG){
            System.out.println("after sort");
            for(Segment s: segments)
                System.out.println(s.start + " "+ s.end);
            System.out.println("");
        }
        
        ArrayList<Long> points = optimalPoints(segments);
        System.out.println(points.size());
        for (Long point : points) {
            System.out.print(point + " ");
        }
    }
}
 
