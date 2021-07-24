public class Main {

    static class Node {
      Node left;
      Node right;
      int data;
      Node(int d) {
        data = d;
      }
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
  
    public static Node construct(int arr[], int l, int r) {
      if (l == r) {
        return new Node(arr[l]);
      }
  
      int mid = (l + r) / 2;
  
      Node root = new Node(arr[mid]);
      root.left = construct(arr, l, mid - 1);
      root.right = construct(arr, mid + 1, r);
  
      return root;
    }
  
    public static void main(String[]args) {
      int arr[] = {12, 25, 30, 50, 60, 75, 100};
  
      Node root = construct(arr, 0, arr.length - 1);
      display(root);
    }
  
  
  }