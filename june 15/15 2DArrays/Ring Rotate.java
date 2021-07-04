import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn  = new Scanner(System.in);

    int n = scn.nextInt();
    int m = scn.nextInt();

    int arr[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    int s = scn.nextInt();
    int r = scn.nextInt();

    rotateShell(arr, s, r);
    display(arr);
  }

  public static void rotateShell(int arr[][], int s, int r) {
    int oneD[] = shellToOneD(arr, s);
    rotate(oneD, r);
    oneDToShell(oneD, arr, s);
  }

  public static void rotate(int[] a, int k) {

    k = k % a.length;
    if (k < 0) {
      k = a.length + k;
    }

    reverse(a, 0, a.length - 1); // full
    reverse(a, 0, k - 1); // B`
    reverse(a, k, a.length - 1); // A`

  }

  public static void reverse(int[] a, int i, int j) {
    while (i < j) {
      int tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;

      i++;
      j--;
    }
  }

  public static int[] shellToOneD(int arr[][], int s) {
    int rmin = s - 1, cmin = s - 1;
    int rmax = arr.length - s, cmax = arr[0].length - s;

    int size = 2 * (rmax - rmin + cmax - cmin);
    int oneD[] = new int[size];
    int idx = 0;

    for (int r = rmin; r <= rmax; r++) {
      oneD[idx] = arr[r][cmin];
      idx++;
    }
    for (int c = cmin + 1; c <= cmax; c++) {
      oneD[idx] = arr[rmax][c];
      idx++;
    }
    for (int r = rmax - 1; r >= rmin; r--) {
      oneD[idx] = arr[r][cmax];
      idx++;
    }
    for (int c = cmax - 1; c >= cmin + 1; c--) {
      oneD[idx] = arr[rmin][c];
      idx++;
    }

    return oneD;
  }

  public static void oneDToShell(int oneD[], int arr[][], int s) {
    int rmin = s - 1, cmin = s - 1;
    int rmax = arr.length - s, cmax = arr[0].length - s;

    int idx = 0;
    for (int r = rmin; r <= rmax; r++) {
      arr[r][cmin] = oneD[idx];
      idx++;
    }
    for (int c = cmin + 1; c <= cmax; c++) {
      arr[rmax][c] = oneD[idx];
      idx++;
    }
    for (int r = rmax - 1; r >= rmin; r--) {
      arr[r][cmax] = oneD[idx];
      idx++;
    }
    for (int c = cmax - 1; c >= cmin + 1; c--) {
      arr[rmin][c] = oneD[idx];
      idx++;
    }
  }

  public static void display(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}