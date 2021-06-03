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

    public static class Pair{
        Node node;
        int status;
        Pair(Node n, int s){
            node = n;
            status = s;
        }
    }

  public static void IterativePreandPostOrder(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));
        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        
        
        while(st.size() > 0){
            
            Pair p = st.peek();
            
            if(p.status == -1){
                pre.append(p.node.data+" ");
                p.status++;
            }else if(p.status == p.node.children.size()){
                post.append(p.node.data+" ");
                st.pop();
            }else{
                Node child = p.node.children.get(p.status);
                p.status++;
                st.push(new Pair(child, -1));
            }
        }
        
        System.out.println(pre);
        System.out.println(post);
        
        
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
    IterativePreandPostOrder(root);
  }

}