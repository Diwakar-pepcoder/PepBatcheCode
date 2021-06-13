import java.io.*;
import java.util.*;

public class Main {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) {
        if(left.size() == 0|| val <= left.peek()){
            left.add(val);
        } else{
            right.add(val);
        }
        balance();
    }
    
    public void balance(){
        if(left.size() == right.size()  +2){
            int val = left.remove();
            right.add(val);
        }
        if(left.size()+1 == right.size()){
            int val = right.remove();
            left.add(val);
        }
    }

    public int remove() {
        if(size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        int val = left.remove();
        balance();
        return val;
    }

    public int peek() {
        if(size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        return left.peek();
    }

    public int size() {
        return left.size() + right.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

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