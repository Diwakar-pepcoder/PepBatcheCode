import java.util.*;

public class Main {
    
      public static class PriorityQueue<T extends Comparable> {
    ArrayList<T> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    private boolean hasHighPriority(int i, int j){
        T a = data.get(i);
        T b = data.get(j);
        if( a.compareTo(b) < 0 ){
            return true;
        }else return false;
    }
    
    private void swap(int i, int j){
        T tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }
    
    private void upheapify(int i){
        int pi = (i-1)/2;
        if(hasHighPriority(i, pi)){
            swap(i, pi);
            if(pi != 0)upheapify(pi);
        }
    }
    
    private void downheapify(int i){
        int li = i*2+1;
        int ri = i*2+2;
        int min = i;
        
        if(li < data.size() && hasHighPriority(li, min)){
            min = li;
        }
        
        if(ri < data.size() && hasHighPriority(ri, min)){
            min = ri;
        }
        
        if(i != min){
            swap(i, min);
            downheapify(min);
        }
    }

    public void add(T val) {
        data.add(val);
        upheapify(data.size()-1);
    }

    public T remove() {
        if(size() == 0){
            System.out.println("Underflow");
            return null;
        }
        swap(0, data.size() - 1);
        T val = data.remove(data.size() - 1);
        downheapify(0);
        return val;
    }

    public T peek() {
        if(size() == 0){
            System.out.println("Underflow");
            return null;
        }
        return data.get(0);
    }

    public int size() {
        return data.size();
    }
  }
  
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
    
    public static void main(String[]a){
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        
    }
}