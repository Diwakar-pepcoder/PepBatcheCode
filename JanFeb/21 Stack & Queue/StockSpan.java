import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
        Stack<Integer> st = new Stack<>();
        int ss[] = new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            
            while(st.size() >0 && arr[st.peek()] <= arr[i])st.pop();
            
            int greaterI = -1;
            if(st.size() >0){
                greaterI = st.peek();
            }
            ss[i] = i-greaterI;
            
            st.push(i);
        }
        
        return ss;
 }

}
