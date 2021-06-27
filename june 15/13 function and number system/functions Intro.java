import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        int n=10;
        int r=4;
        
        int nf = fact(n);
        int rf = fact(r);
        int nmrf = fact(n-r);
        
        System.out.println(nf/(rf*nmrf));
    }
    
    public static int fact(int x){
        int f = 1;
        for(int i=1;i<=x;i++){
            f = f*i;
        }
        System.out.println("hello");
        return f;
    }
    
}






