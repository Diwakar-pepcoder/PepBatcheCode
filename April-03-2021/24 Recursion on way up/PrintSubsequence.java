import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        printSS(scn.nextLine(), "");
    }

    public static void printSS(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        
        String fS = str.substring(1);
        printSS(fS, ans + str.charAt(0));
        printSS(fS, ans + "");
        
    }   

}