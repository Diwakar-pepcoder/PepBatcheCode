import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int m = scn.nextInt();
            printMazePaths(1, 1, n, m, "");
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
        public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        if(sr==dr && sc == dc){
	            System.out.println(psf);
	        }
	        
	        // horizontal
	        if(sc+1<=dc)
	        printMazePaths(sr, sc+1, dr, dc, psf+"h");
	        
	        if(sr+1 <= dr)
	        printMazePaths(sr+1, sc, dr, dc, psf+"v");
	        
	    }


	    public static void printMazePaths3VAR(int sr, int sc, String psf) {
	        if(sr==0 && sc == 0){
	            System.out.println(psf);
	        }
	        
	        // horizontal
	        if(sc!=0)
	        printMazePaths3VAR(sr, sc-1, psf+"h");
	        
	        if(sr != 0)
	        printMazePaths3VAR(sr-1, sc, psf+"v");
	        
	    }
	}
