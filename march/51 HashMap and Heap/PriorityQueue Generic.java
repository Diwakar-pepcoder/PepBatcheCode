import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue<T extends Comparable<T>> {
    ArrayList<T> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(T val) {
        data.add(val);
        upheapify(data.size() - 1);
    }
    
    private boolean isSmaller(int i, int j){
        T a = data.get(i);
        T b = data.get(j);
        if(a.compareTo(b) < 0)return true;
        return false;
    }
    
    private void swap(int i, int j){
        T val = data.get(i);
        data.set(i, data.get(j));
        data.set(j, val);
    }
    
    private void upheapify(int i){
        int pi = (i-1)/2;
        
        while(i >0 && isSmaller(i, pi)){
            swap(i, pi);
            i = pi;
            pi = (i-1)/2;
        }
    }
    
    private void downheapify(int i){
        
        while(true){
            int left = i*2+1;
            int right = i*2+2;
            int min = i;
            
            if(left<data.size() && isSmaller(left, min)){
                min = left;
            }
            if(right<data.size() && isSmaller(right, min)){
                min = right;
            }
            
            if(min==i)break;
            swap(i, min);
            i=min;
        }
        
    }

    public T remove() {
        if(data.size() == 0){
            System.out.println("Underflow");
            return null;
        }
        T val = data.get(0);
        data.set(0, data.get(data.size()-1));
        data.remove(data.size()-1);
        downheapify(0);
        return val;
    }

    public T peek() {
        if(data.size() == 0){
            System.out.println("Underflow");
            return null;
        }
        return data.get(0);
    }

    public int size() {
        return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> qu = new PriorityQueue<>();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}