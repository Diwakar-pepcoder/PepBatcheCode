import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
	    int n = str.length();
	    for(int i=0;i<n;i++){
	        for(int j=i+1; j<=n; j++){
	            String ss = str.substring(i, j);
	            
	            if(isPalindrome(ss)){
	                System.out.println(ss);
	            }
	        }
	    }
	}

    public static boolean isPalindrome(String ss){
        int n = ss.length();
        
        int i=0;
        int j = n-1;
        
        while(i<j){
            char a = ss.charAt(i);
            char b = ss.charAt(j);
            if(a == b){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}