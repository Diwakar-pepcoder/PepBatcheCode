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

  static Node predecessor;
  static Node successor;
  static int status=0;
  public static void predecessorAndSuccessor(Node node, int data) {
        
        if(node.data == data){
            status = 1;
        }else if(status == 0){
            predecessor = node;
        }else if(status == 1){
            successor = node;
            status = 2;
        }
        
        for(Node child: node.children){
            if(status == 2)return;
            predecessorAndSuccessor(child, data);
        }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    predecessor = null;
    successor = null;
    predecessorAndSuccessor(root, data);
    if(predecessor == null){
      System.out.println("Predecessor = Not found");
    } else {
      System.out.println("Predecessor = " + predecessor.data);
    }

    if(successor == null){
      System.out.println("Successor = Not found");
    } else {
      System.out.println("Successor = " + successor.data);
    }
  }

}