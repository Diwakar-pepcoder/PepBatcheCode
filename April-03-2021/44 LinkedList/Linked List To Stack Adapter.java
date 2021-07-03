import java.io.*;
import java.util.*;

public class Main {

  public static class LLToStackAdapter {
    LinkedList<Integer> list;

    public LLToStackAdapter() {
      list = new LinkedList<>();
    }

    int size() {
        return list.size();
    }

    void push(int val) {
        list.addFirst(val);
    }

    int pop() {
        return list.removeFirst();
    }

    int top() {
        return list.peekFirst();
    }

    // int size() {
    //     return list.size();
    // }

    // void push(int val) {
    //     list.push(val);
    // }

    // int pop() {
    //     return list.pcop();
    // }

    // int top() {
    //     return list.peek();
    // }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LLToStackAdapter st = new LLToStackAdapter();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}