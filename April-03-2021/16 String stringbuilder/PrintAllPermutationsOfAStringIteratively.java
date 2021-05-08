import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
		
		int totalP = 1;
		int n = str.length();
		for(int i=2;i<=n;i++){
		    totalP *= i;
		}
		
		for(int div = 0;div<totalP;div++){
		    StringBuilder q = new StringBuilder(str);
		    StringBuilder ans = new StringBuilder();
		    
		    int x = div;
		    for(int i=n;i>=1;i--){
		        int rem = x%i;
		        
		        char ch = q.charAt(rem);
		        ans.append(ch);
		        q.deleteCharAt(rem);
		    
		        x = x/i;
		    }
		    
		    System.out.println(ans);
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}