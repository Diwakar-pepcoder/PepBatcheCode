import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> prefix = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<Integer> value = new Stack<>();
    
    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        
        if(ch >= '0' && ch <= '9'){
            prefix.push(ch+"");
            infix.push(ch+"");
            value.push(ch-'0');
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            solve(prefix, infix, value, ch);
        }
    }
    
    System.out.println(value.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());
 }
 
 public static void solve(Stack<String> prefix, Stack<String> infix, Stack<Integer> value, char op){
        // prefix
        String s2 = prefix.pop();
        String s1 = prefix.pop();
        prefix.push(op+s1+s2);
        
        s2 = infix.pop();
        s1 = infix.pop();
        infix.push("("+s1+op+s2+")");
        
        int b = value.pop();
        int a = value.pop();
        
        if(op == '+'){
            value.push(a+b);
        }else if(op == '-'){
            value.push(a-b);
        }else if(op == '*'){
            value.push(a*b);
        }else{
            value.push(a/b);
        }
 }
 
}