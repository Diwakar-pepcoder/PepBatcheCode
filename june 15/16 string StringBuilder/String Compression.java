import java.io.*;
import java.util.*;

public class Main {

	public static String compression1(String str){
		int n = str.length();
		int i=0;
		int j=0;
		String ans="";
		while(i<n){
		    while(j<n && str.charAt(i) == str.charAt(j)){
		        j++;
		    }
		    
		    ans = ans + str.charAt(i);
		    i=j;
		}
		return ans;
	}
	public static String compression2(String str){
		int n = str.length();
		
		int i=0;
		int j=0;
		String ans="";
		while(i<n){
		    int count=0;
		    while(j<n && str.charAt(i) == str.charAt(j)){
		        j++;
		        count++;
		    }
		    ans = ans + str.charAt(i);
		    if(count > 1){
		        ans = ans + count;
		    }
		    i=j;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}