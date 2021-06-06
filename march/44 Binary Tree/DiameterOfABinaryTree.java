import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

  public static int diameter1(Node node) {
        if(node == null){
            return 0;
        }
        
        int ld = diameter1(node.left);
        int rd = diameter1(node.right);
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        int dia = lh+rh+2;
        
        return Math.max(dia, Math.max(ld, rd));
  }
  
  public static class Pair2{
        int dia;
        int height;
  }
  
  public static Pair2 diameter(Node node){
      if(node == null){
            Pair2 p = new Pair2();
            p.dia = 0;
            p.height = -1;
            return p;
      }
        
        Pair2 lp = diameter(node.left);
        Pair2 rp = diameter(node.right);
        
        int dia = lp.height + rp.height + 2;
        if(lp.dia > dia){
            dia = lp.dia;
        }
        if(rp.dia > dia){
            dia = rp.dia;
        }
        Pair2 p = new Pair2();
        p.dia = dia;
        p.height = Math.max(lp.height, rp.height) + 1;
        return p;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    Pair2 p = diameter(root);
    System.out.println(p.dia);
    // int diameter = 0;
    // diameter = diameter1(root);
    // System.out.println(diameter);
  }

}