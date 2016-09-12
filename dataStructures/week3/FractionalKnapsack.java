import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class FractionalKnapsack {
    static class Item{
        private int v;
        private int w;
        private double valuePerWeight;
        Item(int v, int w){
            this.v = v ;
            this.w = w ;
            this.valuePerWeight = (double) v/w;
        }
    }
    public static class MyComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            if (o1.valuePerWeight < o2.valuePerWeight)
                 return 1;
            return -1;    
        } 
    }
    private static double getOptimalValue(int capacity, ArrayList<Item> items) {
        double value = 0;
        //write your code here
        for(int i=0;i<items.size();i++){
            if(capacity==0)
                return value;
            int minWeight = Math.min(capacity, items.get(i).w);
            value = value + minWeight*items.get(i).valuePerWeight;
            items.get(i).w-= minWeight;
            capacity = capacity - minWeight;
        }
            return value;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(items, new MyComparator());
        // for(int i=0;i<items.size();i++)
            // System.out.println(items.get(i).v +" "+ items.get(i).w + " "+items.get(i).valuePerWeight);
            // System.out.println(a.v +" "+ a.w + " "+a.valuePerWeight);
        System.out.println(getOptimalValue(capacity, items));
    }
} 
