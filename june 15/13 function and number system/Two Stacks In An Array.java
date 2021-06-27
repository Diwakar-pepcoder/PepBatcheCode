import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // code
    
    Stack<Integer> st = new Stack<>();
    int val=1;
    
    for(int i=0;i<str.length();i++){
        st.push(val);
        val++;
        if(str.charAt(i) == 'i'){
            while(st.size() > 0){
                System.out.print(st.pop());
            }
        }
    }
    st.push(val);
    while(st.size() > 0){
        System.out.print(st.pop());
    }
    
 }
}