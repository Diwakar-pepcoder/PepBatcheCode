import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // code
    
    int leftSmall[] = getLeftSmaller(a); // assumption -1 th index -> smallest
    int rightSmall[] = getRightSmaller(a); // assumption n th index -> smallest
    
    int maxArea=0;
    for(int i=0;i<n;i++){
        int width = rightSmall[i] - leftSmall[i] - 1;
        int height = a[i];
        int area = width*height;
        maxArea = Math.max(maxArea, area);
    }
    
    System.out.println(maxArea);
 }
}