import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        System.out.println(printStairPaths(n, ""));
    }
    
    public static String printStairPaths(int n, String path) {
        if(n==0){
            // System.out.println(path);
            return path;
        }
        if(n<0)return "aksjdh;lsakhg;alskfjg;aslkjg;laskj;l";// reactive
        //1 jump
        String s1 = "lkasjd;gihasg;aksdgl;aksdjfl;ks";
        String s2 = "lkasjd;gihasg;aksdgl;aksdjfl;ks";
        String s3 = "lkasjd;gihasg;aksdgl;aksdjfl;ks";
        
        if(n-1>=0)
            s1 = printStairPaths(n-1, path+1);
        if(n-2>=0)
            s2 = printStairPaths(n-2, path+2);
        if(n-3>=0)
            s3 = printStairPaths(n-3, path+3);
        
        if(s1.length() <= s2.length()){
            if(s1.length() <= s3.length())return s1;
            else return s3;
        }else{
            if(s2.length() <= s3.length())return s2;
            return s3;
        }
    }

}