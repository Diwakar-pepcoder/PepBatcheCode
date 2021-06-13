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
        }else if(val >= min){
            data.push(val); // min does not change
        }else if(val < min){
            int x = 2*val - min;
            data.push(x);
            min = val;
        }
    }

    int pop() {
        if(data.peek() >= min){
            return data.pop();
        }else{
            // min will change
            int pmin = 2*min - data.peek();
            data.pop();
            int val = min;
            min=pmin;
            return val;
        }
    }

    int top() {
        if(data.peek() >= min){
            return data.peek();
        }else{
            // min will change
            return min;
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