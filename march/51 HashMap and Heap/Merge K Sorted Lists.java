import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair> {
        ArrayList<Integer> list;
        int ind=0;
        Pair(ArrayList<Integer> l){
            list = l;
        }
        public int compareTo(Pair b){
            // a = this
            // b
            int x = this.list.get(this.ind);
            int y = b.list.get(b.ind);
            if( x < y){
                return -1;
            }else if(x> y){
                return +1;
            }
            return 0;
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(ArrayList<Integer> list : lists){
          pq.add(new Pair(list));
      }
      
      while(pq.size() > 0){
            Pair p = pq.remove();
            
            int val = p.list.get(p.ind);
            rv.add(val);
            p.ind++;
            
            if(p.ind < p.list.size()){
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