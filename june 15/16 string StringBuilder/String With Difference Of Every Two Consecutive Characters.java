import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str){
		StringBuilder sb = new StringBuilder();
		
		int n = str.length();
		for(int i=0;i<=n-2;i++){
		    sb.append(str.charAt(i));
		    
		    int diff = str.charAt(i+1) - str.charAt(i);
		    sb.append(diff);
		}
		sb.append(str.charAt(n-1));

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}