import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        
        Stack<Character> st = new Stack<>();
        
        boolean hasextra = false;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if(ch == ')'){
                if(st.peek() == '('){
                    hasextra = true;
                    break;
                }else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
        
        System.out.println(hasextra);
    }

}