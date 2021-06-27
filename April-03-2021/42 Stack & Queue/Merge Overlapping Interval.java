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
        Pair pairs[] = new Pair[arr.length];
        // int arr
        for(int i=0;i<pairs.length;i++){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        
        Arrays.sort(pairs);
        
        Stack<Pair> st = new Stack<>();
        
        for(Pair n: pairs){
            if(st.size() == 0){
                st.push(n);
            }else {
                Pair p = st.peek();
                if(n.start <= p.end){
                    p.end = Math.max(p.end, n.end);
                }else{
                    st.push(n);
                }
            }
        }
        
        Stack<Pair> st2 = new Stack<>();
        
        while(st.size() >0){
            Pair p = st.pop();
            st2.push(p);
        }
        while(st2.size() > 0){
            Pair p = st2.pop();
            System.out.println(p.start+" "+p.end);
        }
    }

    
    public static class Pair implements Comparable<Pair> {
        int start;// less
        int end;
        Pair(int s, int e){
            start = s;
            end = e;
        }
        
        public int compareTo(Pair b){
            if(this.start < b.start){
                return -1;
            }
            if(this.start > b.start){
                return +1;
            }
            return 0;
        }
        
    }
}
