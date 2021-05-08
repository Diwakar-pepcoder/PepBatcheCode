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
    
    public static class Pair{
        int startTime;
        int endTime;
        Pair(int s, int e){
            this.startTime = s;
            this.endTime = e;
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        Pair[]time = new Pair[arr.length];
        
        for(int i=0;i<arr.length;i++){// arr[i] = start, end
            Pair p = new Pair(arr[i][0], arr[i][1]);
            time[i] = p;
        }
        Arrays.sort(time, (a,b) -> a.startTime - b.startTime);
        
        Stack<Pair> st = new Stack<>();
        
        for(int i=0;i<time.length;i++){
            Pair np = time[i];
            if(st.size() > 0 && np.startTime <= st.peek().endTime){
                // correction
                Pair corrected = new Pair(st.peek().startTime, Math.max(np.endTime, st.peek().endTime));
                st.pop();
                st.push(corrected);
            }else{
                st.push(np);
            }
        }
        
        Stack<Pair> reversed = new Stack<>();
        while(st.size() > 0){
            reversed.push(st.pop());
        }
        
        while(reversed.size() > 0){
            Pair p = reversed.pop();
            System.out.println(p.startTime+" "+p.endTime);
        }
    }

}
