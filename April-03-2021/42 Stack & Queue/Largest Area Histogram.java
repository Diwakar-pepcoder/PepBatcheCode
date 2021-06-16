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
    
    int nsl[] = smallerIndexOnLeft(a);
    int nsr[] = smallerIndexOnRight(a);
    
    int maxArea=0;
    
    for(int i=0;i<n;i++){
        int height = a[i];
        int width = nsr[i] - nsl[i] - 1;
        int area = height*width;
        maxArea = Math.max(maxArea, area);
    }
    System.out.println(maxArea);
 }
 
 public static int[] smallerIndexOnRight(int arr[]){
        int n = arr.length;
        
        int ngr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0;i--){
            while(st.size() >0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            int ans=n;
            if(st.size()>0){
                ans = st.peek();
            }
            ngr[i] = ans;
            
            st.push(i);
        }
        return ngr;
 }
 
 public static int[] smallerIndexOnLeft(int []arr){
        int n = arr.length;
        
        int ngr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n;i++){
            while(st.size() >0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            int ans=-1;
            if(st.size()>0){
                ans = st.peek();
            }
            ngr[i] = ans;
            
            st.push(i);
        }
        return ngr;
 }
 
}