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
        
        for(int jump = 1; sc+jump <= dc ; jump++){
            ArrayList<String> hfaith = getMazePaths(sr, sc+jump, dr, dc);
            for(String s: hfaith){
                ans.add("h"+jump+s);
            }
        }
        
        for(int jump = 1; sr+jump <= dr ; jump++){
            ArrayList<String> vfaith = getMazePaths(sr+jump, sc, dr, dc);
            for(String s: vfaith){
                ans.add("v"+jump+s);
            }
        }
        
        for(int jump = 1; sr+jump<=dr && sc+jump<=dc ; jump++){
            ArrayList<String> dfaith = getMazePaths(sr+jump, sc+jump, dr, dc);
            for(String s: dfaith){
                ans.add("d"+jump+s);
            }
        }
        
        return ans;
    }

}


