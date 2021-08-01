import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair> {
        ArrayList<Integer> list;
        int idx;
        Pair(ArrayList<Integer> l, int i){
            list = l;
            idx = i;
        }
        
        public int compareTo(Pair b){
            Pair a = this;
            
            int x = a.list.get(a.idx);
            int y = b.list.get(b.idx);
            
            if(x < y)return -1;
            if(x > y)return +1;
            return 0;
        }
    }
    
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(ArrayList<Integer> inner: lists){
            Pair p = new Pair(inner, 0);
            pq.add(p);
        }

        while(pq.size() > 0){
            Pair p = pq.remove();
            int val = p.list.get(p.idx);
            rv.add(val);
            
            p.idx++;
            if(p.idx < p.list.size()){
                pq.add(p);
            }
        }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}