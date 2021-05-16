import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        if(n<0){
            ArrayList<String> ans = new ArrayList<>();
            return ans;
        }
        
        ArrayList<String> first = getStairPaths(n-1);
        ArrayList<String> second = getStairPaths(n-2);
        ArrayList<String> third = getStairPaths(n-3);
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(String s: first){
            ans.add(1+s);
        }
        for(String s: second){
            ans.add(2+s);
        }
        for(String s: third){
            ans.add(3+s);
        }
        return ans;
    }

}