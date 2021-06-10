import java.io.*;
import java.util.*;

public class Main {
    
    public static class Node{
        Node left, right;
        int data;
        Node(int d){
            data = d;
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 25, 32, 50, 62, 75, 100};
        
        Node root = construct(arr, 0, arr.length-1);
        display(root);
    }
    
    public static Node construct(int arr[], int lo, int hi){
        if(lo>hi)return null;
        
        int mid = (lo+hi)/2;
        
        Node root = new Node(arr[mid]);
        root.left = construct(arr, lo, mid-1);
        root.right = construct(arr, mid+1, hi);
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
    
}