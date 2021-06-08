import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    
    Stack<String> prefix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<Character> operator = new Stack<>();
    
    for(int i=0;i<exp.length(); i++){
        char ch = exp.charAt(i);
        if(ch >= 'a' && ch<='z'){
            prefix.push(ch+"");
            postfix.push(ch+"");
        }else if(ch == '('){
            operator.push(ch);
        }else if(ch == ')'){
            while(operator.peek() != '('){
                solve(prefix, postfix, operator);
            }
            operator.pop(); // (
        }else if( ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operator.size() >0 && operator.peek() != '(' && priority(operator.peek()) >= priority(ch)){
                solve(prefix, postfix, operator);
            }
            operator.push(ch);
        }
    }
    while(operator.size() > 0){
        solve(prefix, postfix, operator);
    }
    System.out.println(postfix.pop());
    System.out.println(prefix.pop());
 }
 public static void solve(Stack<String> prefix, Stack<String> postfix, Stack<Character> operator){
        char op = operator.pop();
        
        // prefix
        String v2 = prefix.pop();
        String v1 = prefix.pop();
        prefix.push(op+v1+v2);
        
        v2 = postfix.pop();
        v1 = postfix.pop();
        postfix.push(v1+v2+op);
 }
 
 public static int priority(char ch){
        if(ch == '+' || ch == '-')return 1;
        return 2;
 }
 
}