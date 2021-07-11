import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
		int n = str.length();
		int total = 1;
		for(int i=2;i<=n;i++){
		    total = total*i;
		}
		
		for(int val =0;val<total;val++){
		    StringBuilder sub = new StringBuilder(str);
		    StringBuilder ans = new StringBuilder();
		    
		    int x = val;
		    for(int div = n;div>=1;div--){
		        int q = x/div;
		        int r = x%div;
		        
		        char ch = sub.charAt(r);
		        ans.append(ch);
		        sub.deleteCharAt(r);
		        
		        x=q;
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