import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
	    
	    StringBuilder sb = new StringBuilder("abc");
	    
	    System.out.println(sb);
	    
	    sb.append("def");
	    System.out.println(sb);
	    
	    char ch = sb.charAt(0);
	    System.out.println(ch);
	    
	    System.out.println(sb.length());
	    System.out.println(sb.substring(0,2));
	    
	    sb.setCharAt(0, 'x');
	    System.out.println(sb);
	    
	    sb.insert(1, "m");
	    System.out.println(sb);
	    
	    sb.deleteCharAt(1);
	    System.out.println(sb);
	    
	}
}