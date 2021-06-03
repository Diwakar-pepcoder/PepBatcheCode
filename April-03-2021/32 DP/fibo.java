import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    // System.out.println(fibR(n));
    int qb[] = new int[n + 1];
    // System.out.println(fibM(n, qb));
    System.out.println(fibT(n, qb));
  }

  public static int fibR(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    int nm1 = fibR(n - 1);
    int nm2 = fibR(n - 2);

    int nthfib = nm1 + nm2;
    return nthfib;
  }

  public static int fibM(int n, int qb[]) {
    if (n == 0 || n == 1) {
      qb[n] = n;
      return n;
    }
    if (qb[n] != 0) {
      return qb[n];
    }
    int nm1 = fibM(n - 1, qb);
    int nm2 = fibM(n - 2, qb);

    int nthfib = nm1 + nm2;
    qb[n] = nthfib;
    return nthfib;
  }

  public static int fibT(int n, int qb[]) {
    for (int i = 0; i <= n; i++) {
        if (i == 0 || i == 1) {
            qb[i] = i;
            continue;
        }

        int nm1 = qb[i-1];
        int nm2 = qb[i-2];

        int nthfib = nm1 + nm2;
        qb[i] = nthfib;
        continue;
    }
    return qb[n];
  }

}