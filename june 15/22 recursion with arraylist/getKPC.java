import java.io.*;
import java.util.*;

public class Main {
    
    static String[] keys = {
            ".;",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tu",
            "vwx",
            "yz"
    };
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        ArrayList<String> list = getKPC(str);
        System.out.println(list);
    }

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> myAns = new ArrayList<String>();
            myAns.add("");
            return myAns;
        }
        
        String fstr = str.substring(1);
        ArrayList<String> fans = getKPC(fstr);
        
        ArrayList<String> myAns = new ArrayList<String>();
        
        int index = str.charAt(0)-'0';
        String code = keys[index];
        for(int i=0;i<code.length();i++){
            char ch = code.charAt(i);
            
            for(String s: fans){
                myAns.add(ch+s);
            }
        }
        
        return myAns;
    }

}