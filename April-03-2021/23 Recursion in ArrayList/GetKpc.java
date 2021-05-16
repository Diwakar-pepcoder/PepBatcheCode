import java.io.*;
import java.util.*;

public class Main {
    
    static String []codes = {
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
        String s = scn.nextLine();
        System.out.println(getKPC(s));
    }

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> ans = new ArrayList<String>();
            ans.add("");
            return ans;
        }
        
        ArrayList<String> faithAns = getKPC(str.substring(1));
        
        ArrayList<String> myAns = new ArrayList<String>();
        
        char firstchar = str.charAt(0);
        String myCode = codes[firstchar - '0'];
        
        for(int i=0;i<myCode.length();i++){
            char ch = myCode.charAt(i);
            for(String s: faithAns){
                myAns.add(ch+s);
            }
        }
        
        return myAns;
    }

}