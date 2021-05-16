import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    public void upheapify(int i){
        if(i == 0)return;
        
        int pi = (i-1)/2;
        
        if(data.get(i) < data.get(pi)){
            swap(i, pi);
            upheapify(pi);
        }
    }

    public void add(int val) {
        data.add(val);
        upheapify(data.size() - 1);
    }
    
    public void swap(int i, int j){
        int t = data.get(i);
        data.set(i, data.get(j));
        data.set(j, t);
    }

    public void downheapfiy(int i){
        int li = i*2+1;
        int ri = i*2+2;
        
        int min = i;
        
        if(li < data.size() && data.get(li)<data.get(min))min = li;
        if(ri < data.size() && data.get(ri)<data.get(min))min = ri;
        
        if(min != i){
            swap(i, min);
            downheapfiy(min);
        }
    }

    public int remove() {
        if(data.size() == 0){
            System.out.println("Underflow");
            return -1;
        }else{
            swap(0, data.size()-1);
            int val = data.remove( data.size()-1);
            downheapfiy(0);
            return val;
        }
    }

    public int peek() {
        if(data.size() == 0){
            System.out.println("Underflow");
            return -1;
        }else{
            return data.get(0);
        }
    }

    public int size() {
        return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

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