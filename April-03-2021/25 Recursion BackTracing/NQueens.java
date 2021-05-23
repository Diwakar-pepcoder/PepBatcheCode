import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printNQueens(new int[n][n], "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length){
            System.out.println(qsf+".");
            return;
        }
        
        for(int j=0;j<chess.length;j++){
            if(isSafe(chess, row, j)){
                chess[row][j] = 1;
                printNQueens(chess, qsf+row+"-"+j+", ", row+1);
                chess[row][j] = 0;
            }
        }
    }
    
    public static boolean isSafe(int[][]chess, int r, int c){
        // upward
        for(int i=r-1; i>=0;i--){
            if(chess[i][c] == 1)return false;
        }
        
        // up left
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            if(chess[i][j] == 1)return false;
        }
        
        // up right
        for(int i=r-1, j=c+1; i >= 0&& j < chess.length; i--, j++){
            if(chess[i][j] == 1)return false;
        }
        return true;
    }
    
}
