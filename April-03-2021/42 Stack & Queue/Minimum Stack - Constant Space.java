import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
    }

    int size() {
        return data.size();
    }

    void push(int val) {
        if(size() == 0){
            data.push(val);
            min = val;
        }else if(val < min){
            int x = val+val-min;
            data.push(x);
            min = val;
        }else{
            data.push(val);
        }
    }

    int pop() {
        if(size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        if(data.peek() < min){
            int pmin = min+min-data.peek();
            data.pop();
            int val = min;
            min = pmin;
            return val;
        }else{
            return data.pop();
        }
    }

    int top() {
        if(size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        if(data.peek() < min){
            return min;
        }else{
            return data.peek();
        }
    }

    int min() {
        return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}