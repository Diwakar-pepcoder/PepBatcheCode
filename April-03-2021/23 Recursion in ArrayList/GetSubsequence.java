import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        ArrayList<String> al =  gss(s);
        System.out.println(al);
    }

    public static ArrayList<String> gss(String str) {
        
        if(str.length() == 0){
            ArrayList<String> myAl = new ArrayList<>();
            myAl.add("");
            return myAl;
        }
        
        String fs = str.substring(1);
        ArrayList<String> faithAl = gss(fs);
        
        ArrayList<String> myAl = new ArrayList<>();
        
        for(String s: faithAl){
            myAl.add(s);
        }
        
        for(String s: faithAl){
            myAl.add(str.charAt(0) + s);
        }
        
        return myAl;
    }

}