import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int a = 1;
        int b = 2;
        
        for(int i=2;i<=n;i++){
            int c = a+b;
            a=b;
            b=c;
        }
        System.out.println(a);
    }
}