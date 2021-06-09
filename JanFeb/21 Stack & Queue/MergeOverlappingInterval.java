import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        Pair []pair = new Pair[arr.length];
        for(int i=0;i<arr.length;i++){
            pair[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pair);
        
        Stack<Pair> st = new Stack<>();
        
        for(Pair n: pair){
            
            if(st.size() > 0){
                Pair p = st.peek();
                if(n.start <= p.end){
                    Pair merged = new Pair(p.start, Math.max(n.end, p.end));
                    st.pop();
                    st.push(merged);
                }else{
                    st.push(n);
                }
            }else{
                st.push(n);
            }
        }
        
        Stack<Pair> ors = new Stack<>();
        while(st.size() > 0){
            Pair p = st.pop();
            ors.push(p);
        }
        
        while(ors.size() > 0){
            Pair p = ors.pop();
            System.out.println(p.start + " "+ p.end);
        }
        
    }
    
    public static class Pair implements Comparable<Pair>{
        int start;
        int end;
        Pair(int s, int e){
            start  = s;
            end = e;
        }
        
        public int compareTo(Pair b){
            Pair a = this;
            
            if(a.start < b.start)return -1;
            if(b.start < a.start)return +1;
            return 0;
        }
    }

}