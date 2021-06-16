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
    int k = Integer.parseInt(br.readLine());
    
    // code
    int ngr[] = nextGreaterRightIndex(a);
    int g = 0;
    for(int ws=0, we=k-1; we<n; ws++, we++){
        if(g<ws){
            g=ws;
        }
        while(ngr[g] <= we){
            g = ngr[g];
        }
        
        System.out.println(a[g]);
    }
    
 }
 
 public static int[] nextGreaterRightIndex(int arr[]){
        // flag = n
        int n = arr.length;
        
        int ngr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0;i--){
            while(st.size() >0 && arr[st.peek()] <= arr[i]){
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
}
