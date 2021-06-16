import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String s = scn.nextLine();
        
        Stack<Character> st = new Stack<>();
        
        boolean ok=true;
        for(int i=0;i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch =='(' || ch=='[' || ch == '{'){
                st.push(ch);
            }else if(ch == ')'){
                if(st.size() == 0 || st.peek() != '('){
                    ok = false;
                    break;
                }
                st.pop();
            }else if(ch == ']'){
                if(st.size() == 0 || st.peek() != '['){
                    ok = false;
                    break;
                }
                st.pop();
            }else if( ch == '}'){
                if(st.size() == 0 || st.peek() != '{'){
                    ok = false;
                    break;
                }
                st.pop();
            }
        }
        if(ok == true && st.size() == 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        
    }

}