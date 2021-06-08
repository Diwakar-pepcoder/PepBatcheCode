import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            st.push(i);
        }
        
        while(st.size() >=2){
            int x = st.pop();
            int y = st.pop();
            if(arr[x][y] == 0){
                st.push(x);
            }else{
                st.push(y);
            }
        }
        
        int pc = st.pop();
        
        boolean cel = true;
        for(int i=0;i<arr.length;i++){
            if(pc == i)continue;
            if(arr[pc][i] == 1 || arr[i][pc] == 0){
                cel = false;
                break;
            }
        }
        
        if(cel){
            System.out.println(pc);
        }else{
            System.out.println("none");
        }
    }

}











