import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int same[] = new int[n+1];
        int diff[] = new int[n+1];
        
        diff[1] = k;
        
        for(int i=2;i<=n;i++){
            diff[i] = diff[i-1]*(k-1) + same[i-1]*(k-1);
            same[i] = diff[i-1];
        }
        
        int total = diff[n] + same[n];
        System.out.println(total);
    }
}