import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    
    Stack<Integer> value = new Stack<>();
    Stack<Character> operator = new Stack<>();
    
    for(int i=0;i<exp.length(); i++){
        
        char ch = exp.charAt(i);
        
        if(ch >= '0' && ch<='9'){
            value.push(ch-'0');
        }else if(ch == '('){
            operator.push(ch);
        }else if(ch == ')'){
            while(operator.peek() != '('){
                solve(value, operator);
            }
            operator.pop(); // (
        }else if( ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(
                operator.size() >0 &&
                operator.peek() != '(' &&
                priority(operator.peek()) >= priority(ch)){
                solve(value, operator);
            }
            operator.push(ch);
        }
    }
    
    while(operator.size() > 0){
        solve(value, operator);
    }
    
    System.out.println(value.pop());
 }
 
 public static void solve(Stack<Integer> value, Stack<Character> operator){
        int b = value.pop();
        int a = value.pop();
        char op = operator.pop();
        
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
 
 public static int priority(char ch){
        if(ch == '+' || ch == '-')return 1;
        return 2;
 }
 
}