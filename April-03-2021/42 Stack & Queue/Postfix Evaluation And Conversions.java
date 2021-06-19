import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> value = new Stack<>();
    Stack<String> prefix = new Stack<>();
    Stack<String> infix = new Stack<>();
    
    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        
        if(ch>='0' && ch <= '9'){
            value.push(ch-'0');
            prefix.push(""+ch);
            infix.push(""+ch);
        }else{
            int b=value.pop();
            int a=value.pop();
            if(ch == '+'){
                value.push(a+b);
            }else if(ch == '-'){
                value.push(a-b);
            }else if(ch == '*'){
                value.push(a*b);
            }else{
                value.push(a/b);
            }
            String v2 = prefix.pop();
            String v1 = prefix.pop();
            prefix.push(ch+v1+v2);
            v2 = infix.pop();
            v1 = infix.pop();
            infix.push("("+v1+ch+v2+")");
        }
    }
    System.out.println(value.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());
    
 }
}