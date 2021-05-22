import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        printEncodings(scn.nextLine(), "");
    }

    public static void printEncodings(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        
        // single
        int x = Integer.parseInt(str.charAt(0)+"");
        if(x>=1 && x<= 9){
            char ch  = (char)(x-1+'a');
            printEncodings(str.substring(1), asf+ch);
        }
        
        // pair
        if(str.length() >= 2){
            String s = str.substring(0,2);
            int val = Integer.parseInt(s);
            if(val >= 10 && val <= 26){
                char ch  = (char)(val-1+'a');
                printEncodings(str.substring(2), asf+ch);
            }
        }
    }

}