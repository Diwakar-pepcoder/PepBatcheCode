import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> ans = getMazePaths(1, 1, n, m);
        System.out.println(ans);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        if(sc < dc){
            ArrayList<String> hfaith = getMazePaths(sr, sc+1, dr, dc);
            for(String s: hfaith){
                ans.add("h"+s);
            }
        }
        
        if(sr < dr){
            ArrayList<String> vfaith = getMazePaths(sr+1, sc, dr, dc);
            for(String s: vfaith){
                ans.add("v"+s);
            }
        }
        
        return ans;
    }

}