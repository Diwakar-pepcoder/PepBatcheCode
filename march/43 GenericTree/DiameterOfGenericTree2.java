import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static Pair getDiameter(Node node){
        int h1=-1;// max
        int h2=-1;// smax
        int dia=0;
        for(Node child: node.children){
            Pair p = getDiameter(child);
            if(p.d > dia){
                dia = p.d;
            }
            if(p.h > h1){
                h2 = h1;
                h1 = p.h;
            }else if(p.h > h2){
                h2 = p.h;
            }
        }
        
        if(h1+h2+2 > dia){
            dia = h1+h2+2;
        }
        Pair mydata = new Pair();
        mydata.d = dia;
        mydata.h = h1+1;
        return mydata;
  }
  public static class Pair{
        int d=0;
        int h=-1;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    Node root = construct(arr);
    Pair p = getDiameter(root);
    System.out.println(p.d);
  }

}